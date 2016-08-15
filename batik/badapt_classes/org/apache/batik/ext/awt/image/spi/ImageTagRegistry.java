package org.apache.batik.ext.awt.image.spi;
public class ImageTagRegistry implements org.apache.batik.ext.awt.image.spi.ErrorConstants {
    java.util.List entries = new java.util.LinkedList();
    java.util.List extensions = null;
    java.util.List mimeTypes = null;
    org.apache.batik.ext.awt.image.URLImageCache rawCache;
    org.apache.batik.ext.awt.image.URLImageCache imgCache;
    public ImageTagRegistry() { this(null, null); }
    public ImageTagRegistry(org.apache.batik.ext.awt.image.URLImageCache rawCache,
                            org.apache.batik.ext.awt.image.URLImageCache imgCache) {
        super(
          );
        if (rawCache ==
              null)
            rawCache =
              new org.apache.batik.ext.awt.image.URLImageCache(
                );
        if (imgCache ==
              null)
            imgCache =
              new org.apache.batik.ext.awt.image.URLImageCache(
                );
        this.
          rawCache =
          rawCache;
        this.
          imgCache =
          imgCache;
    }
    public void flushCache() { rawCache.flush();
                               imgCache.flush(); }
    public void flushImage(org.apache.batik.util.ParsedURL purl) {
        rawCache.
          clear(
            purl);
        imgCache.
          clear(
            purl);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter checkCache(org.apache.batik.util.ParsedURL purl,
                                                                       org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace) {
        boolean needRawData =
          colorSpace !=
          null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        org.apache.batik.ext.awt.image.URLImageCache cache;
        if (needRawData)
            cache =
              rawCache;
        else
            cache =
              imgCache;
        ret =
          cache.
            request(
              purl);
        if (ret ==
              null) {
            cache.
              clear(
                purl);
            return null;
        }
        if (colorSpace !=
              null)
            ret =
              new org.apache.batik.ext.awt.image.renderable.ProfileRable(
                ret,
                colorSpace);
        return ret;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter readURL(org.apache.batik.util.ParsedURL purl) {
        return readURL(
                 null,
                 purl,
                 null,
                 true,
                 true);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter readURL(org.apache.batik.util.ParsedURL purl,
                                                                    org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace) {
        return readURL(
                 null,
                 purl,
                 colorSpace,
                 true,
                 true);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter readURL(java.io.InputStream is,
                                                                    org.apache.batik.util.ParsedURL purl,
                                                                    org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace,
                                                                    boolean allowOpenStream,
                                                                    boolean returnBrokenLink) {
        if (is !=
              null &&
              !is.
              markSupported(
                ))
            is =
              new java.io.BufferedInputStream(
                is);
        boolean needRawData =
          colorSpace !=
          null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        org.apache.batik.ext.awt.image.URLImageCache cache =
          null;
        if (purl !=
              null) {
            if (needRawData)
                cache =
                  rawCache;
            else
                cache =
                  imgCache;
            ret =
              cache.
                request(
                  purl);
            if (ret !=
                  null) {
                if (colorSpace !=
                      null)
                    ret =
                      new org.apache.batik.ext.awt.image.renderable.ProfileRable(
                        ret,
                        colorSpace);
                return ret;
            }
        }
        boolean openFailed =
          false;
        java.util.List mimeTypes =
          getRegisteredMimeTypes(
            );
        java.util.Iterator i;
        i =
          entries.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                i.
                next(
                  );
            if (re instanceof org.apache.batik.ext.awt.image.spi.URLRegistryEntry) {
                if (purl ==
                      null ||
                      !allowOpenStream)
                    continue;
                org.apache.batik.ext.awt.image.spi.URLRegistryEntry ure =
                  (org.apache.batik.ext.awt.image.spi.URLRegistryEntry)
                    re;
                if (ure.
                      isCompatibleURL(
                        purl)) {
                    ret =
                      ure.
                        handleURL(
                          purl,
                          needRawData);
                    if (ret !=
                          null)
                        break;
                }
                continue;
            }
            if (re instanceof org.apache.batik.ext.awt.image.spi.StreamRegistryEntry) {
                org.apache.batik.ext.awt.image.spi.StreamRegistryEntry sre =
                  (org.apache.batik.ext.awt.image.spi.StreamRegistryEntry)
                    re;
                if (openFailed)
                    continue;
                try {
                    if (is ==
                          null) {
                        if (purl ==
                              null ||
                              !allowOpenStream)
                            break;
                        try {
                            is =
                              purl.
                                openStream(
                                  mimeTypes.
                                    iterator(
                                      ));
                        }
                        catch (java.io.IOException ioe) {
                            openFailed =
                              true;
                            continue;
                        }
                        if (!is.
                              markSupported(
                                ))
                            is =
                              new java.io.BufferedInputStream(
                                is);
                    }
                    if (sre.
                          isCompatibleStream(
                            is)) {
                        ret =
                          sre.
                            handleStream(
                              is,
                              purl,
                              needRawData);
                        if (ret !=
                              null)
                            break;
                    }
                }
                catch (java.io.StreamCorruptedException sce) {
                    is =
                      null;
                }
                continue;
            }
        }
        if (cache !=
              null)
            cache.
              put(
                purl,
                ret);
        if (ret ==
              null) {
            if (!returnBrokenLink)
                return null;
            if (openFailed)
                return getBrokenLinkImage(
                         this,
                         ERR_URL_UNREACHABLE,
                         null);
            return getBrokenLinkImage(
                     this,
                     ERR_URL_UNINTERPRETABLE,
                     null);
        }
        if (org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
              hasBrokenLinkProperty(
                ret)) {
            return returnBrokenLink
              ? ret
              : null;
        }
        if (colorSpace !=
              null)
            ret =
              new org.apache.batik.ext.awt.image.renderable.ProfileRable(
                ret,
                colorSpace);
        return ret;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter readStream(java.io.InputStream is) {
        return readStream(
                 is,
                 null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter readStream(java.io.InputStream is,
                                                                       org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace) {
        if (!is.
              markSupported(
                ))
            is =
              new java.io.BufferedInputStream(
                is);
        boolean needRawData =
          colorSpace !=
          null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        java.util.Iterator i =
          entries.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                i.
                next(
                  );
            if (!(re instanceof org.apache.batik.ext.awt.image.spi.StreamRegistryEntry))
                continue;
            org.apache.batik.ext.awt.image.spi.StreamRegistryEntry sre =
              (org.apache.batik.ext.awt.image.spi.StreamRegistryEntry)
                re;
            try {
                if (sre.
                      isCompatibleStream(
                        is)) {
                    ret =
                      sre.
                        handleStream(
                          is,
                          null,
                          needRawData);
                    if (ret !=
                          null)
                        break;
                }
            }
            catch (java.io.StreamCorruptedException sce) {
                break;
            }
        }
        if (ret ==
              null)
            return getBrokenLinkImage(
                     this,
                     ERR_STREAM_UNREADABLE,
                     null);
        if (colorSpace !=
              null &&
              !org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
              hasBrokenLinkProperty(
                ret))
            ret =
              new org.apache.batik.ext.awt.image.renderable.ProfileRable(
                ret,
                colorSpace);
        return ret;
    }
    public synchronized void register(org.apache.batik.ext.awt.image.spi.RegistryEntry newRE) {
        float priority =
          newRE.
          getPriority(
            );
        java.util.ListIterator li;
        li =
          entries.
            listIterator(
              );
        while (li.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                li.
                next(
                  );
            if (re.
                  getPriority(
                    ) >
                  priority) {
                li.
                  previous(
                    );
                li.
                  add(
                    newRE);
                return;
            }
        }
        li.
          add(
            newRE);
        extensions =
          null;
        mimeTypes =
          null;
    }
    public synchronized java.util.List getRegisteredExtensions() {
        if (extensions !=
              null)
            return extensions;
        extensions =
          new java.util.LinkedList(
            );
        java.util.Iterator iter =
          entries.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                iter.
                next(
                  );
            extensions.
              addAll(
                re.
                  getStandardExtensions(
                    ));
        }
        extensions =
          java.util.Collections.
            unmodifiableList(
              extensions);
        return extensions;
    }
    public synchronized java.util.List getRegisteredMimeTypes() {
        if (mimeTypes !=
              null)
            return mimeTypes;
        mimeTypes =
          new java.util.LinkedList(
            );
        java.util.Iterator iter =
          entries.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                iter.
                next(
                  );
            mimeTypes.
              addAll(
                re.
                  getMimeTypes(
                    ));
        }
        mimeTypes =
          java.util.Collections.
            unmodifiableList(
              mimeTypes);
        return mimeTypes;
    }
    static org.apache.batik.ext.awt.image.spi.ImageTagRegistry
      registry =
      null;
    public static synchronized org.apache.batik.ext.awt.image.spi.ImageTagRegistry getRegistry() {
        if (registry !=
              null)
            return registry;
        registry =
          new org.apache.batik.ext.awt.image.spi.ImageTagRegistry(
            );
        registry.
          register(
            new org.apache.batik.ext.awt.image.spi.JDKRegistryEntry(
              ));
        java.util.Iterator iter =
          org.apache.batik.util.Service.
          providers(
            org.apache.batik.ext.awt.image.spi.RegistryEntry.class);
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.spi.RegistryEntry re =
              (org.apache.batik.ext.awt.image.spi.RegistryEntry)
                iter.
                next(
                  );
            registry.
              register(
                re);
        }
        return registry;
    }
    static org.apache.batik.ext.awt.image.spi.BrokenLinkProvider
      defaultProvider =
      new org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider(
      );
    static org.apache.batik.ext.awt.image.spi.BrokenLinkProvider
      brokenLinkProvider =
      null;
    public static synchronized org.apache.batik.ext.awt.image.renderable.Filter getBrokenLinkImage(java.lang.Object base,
                                                                                                   java.lang.String code,
                                                                                                   java.lang.Object[] params) {
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        if (brokenLinkProvider !=
              null)
            ret =
              brokenLinkProvider.
                getBrokenLinkImage(
                  base,
                  code,
                  params);
        if (ret ==
              null)
            ret =
              defaultProvider.
                getBrokenLinkImage(
                  base,
                  code,
                  params);
        return ret;
    }
    public static synchronized void setBrokenLinkProvider(org.apache.batik.ext.awt.image.spi.BrokenLinkProvider provider) {
        brokenLinkProvider =
          provider;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tYAxxdL1hMRCWq4PGk2eFsSwxaLFLlNn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
