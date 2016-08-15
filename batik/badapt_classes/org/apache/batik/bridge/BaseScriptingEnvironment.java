package org.apache.batik.bridge;
public class BaseScriptingEnvironment {
    public static final java.lang.String INLINE_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.inline.script.description";
    public static final java.lang.String EVENT_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.event.script.description";
    public static boolean isDynamicDocument(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt =
          doc.
          getDocumentElement(
            );
        if (elt !=
              null &&
              org.apache.batik.util.SVGConstants.
                SVG_NAMESPACE_URI.
              equals(
                elt.
                  getNamespaceURI(
                    ))) {
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONABORT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONERROR_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONRESIZE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONUNLOAD_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONSCROLL_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONZOOM_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            return isDynamicElement(
                     ctx,
                     doc.
                       getDocumentElement(
                         ));
        }
        return false;
    }
    public static boolean isDynamicElement(org.apache.batik.bridge.BridgeContext ctx,
                                           org.w3c.dom.Element elt) {
        java.util.List bridgeExtensions =
          ctx.
          getBridgeExtensions(
            elt.
              getOwnerDocument(
                ));
        return isDynamicElement(
                 elt,
                 ctx,
                 bridgeExtensions);
    }
    public static boolean isDynamicElement(org.w3c.dom.Element elt,
                                           org.apache.batik.bridge.BridgeContext ctx,
                                           java.util.List bridgeExtensions) {
        java.util.Iterator i =
          bridgeExtensions.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.bridge.BridgeExtension bridgeExtension =
              (org.apache.batik.bridge.BridgeExtension)
                i.
                next(
                  );
            if (bridgeExtension.
                  isDynamicElement(
                    elt)) {
                return true;
            }
        }
        if (org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI.
              equals(
                elt.
                  getNamespaceURI(
                    ))) {
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYUP_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYDOWN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYPRESS_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONLOAD_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONERROR_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONACTIVATE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONCLICK_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONFOCUSIN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONFOCUSOUT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEDOWN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEMOVE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEOUT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEOVER_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEUP_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
        }
        for (org.w3c.dom.Node n =
               elt.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                if (isDynamicElement(
                      ctx,
                      (org.w3c.dom.Element)
                        n)) {
                    return true;
                }
            }
        }
        return false;
    }
    protected static final java.lang.String EVENT_NAME =
      "event";
    protected static final java.lang.String ALTERNATE_EVENT_NAME =
      "evt";
    protected static final java.lang.String APPLICATION_ECMASCRIPT =
      "application/ecmascript";
    protected org.apache.batik.bridge.BridgeContext
      bridgeContext;
    protected org.apache.batik.bridge.UserAgent userAgent;
    protected org.w3c.dom.Document document;
    protected org.apache.batik.util.ParsedURL docPURL;
    protected java.util.Set languages = new java.util.HashSet(
      );
    protected org.apache.batik.script.Interpreter
      interpreter;
    public BaseScriptingEnvironment(org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        bridgeContext =
          ctx;
        document =
          ctx.
            getDocument(
              );
        docPURL =
          new org.apache.batik.util.ParsedURL(
            ((org.w3c.dom.svg.SVGDocument)
               document).
              getURL(
                ));
        userAgent =
          bridgeContext.
            getUserAgent(
              );
    }
    public org.apache.batik.script.Window createWindow(org.apache.batik.script.Interpreter interp,
                                                       java.lang.String lang) {
        return new org.apache.batik.bridge.BaseScriptingEnvironment.Window(
          interp,
          lang);
    }
    public org.apache.batik.script.Window createWindow() {
        return createWindow(
                 null,
                 null);
    }
    public org.apache.batik.script.Interpreter getInterpreter() {
        if (interpreter !=
              null)
            return interpreter;
        org.w3c.dom.svg.SVGSVGElement root =
          (org.w3c.dom.svg.SVGSVGElement)
            document.
            getDocumentElement(
              );
        java.lang.String lang =
          root.
          getContentScriptType(
            );
        return getInterpreter(
                 lang);
    }
    public org.apache.batik.script.Interpreter getInterpreter(java.lang.String lang) {
        interpreter =
          bridgeContext.
            getInterpreter(
              lang);
        if (interpreter ==
              null) {
            if (languages.
                  contains(
                    lang)) {
                return null;
            }
            languages.
              add(
                lang);
            return null;
        }
        if (!languages.
              contains(
                lang)) {
            languages.
              add(
                lang);
            initializeEnvironment(
              interpreter,
              lang);
        }
        return interpreter;
    }
    public void initializeEnvironment(org.apache.batik.script.Interpreter interp,
                                      java.lang.String lang) {
        interp.
          bindObject(
            "window",
            createWindow(
              interp,
              lang));
    }
    public void loadScripts() { org.apache.batik.script.Window window =
                                  null;
                                org.w3c.dom.NodeList scripts =
                                  document.
                                  getElementsByTagNameNS(
                                    org.apache.batik.util.SVGConstants.
                                      SVG_NAMESPACE_URI,
                                    org.apache.batik.util.SVGConstants.
                                      SVG_SCRIPT_TAG);
                                int len =
                                  scripts.
                                  getLength(
                                    );
                                if (len ==
                                      0) {
                                    return;
                                }
                                for (int i =
                                       0;
                                     i <
                                       len;
                                     i++) {
                                    org.apache.batik.dom.AbstractElement script =
                                      (org.apache.batik.dom.AbstractElement)
                                        scripts.
                                        item(
                                          i);
                                    java.lang.String type =
                                      script.
                                      getAttributeNS(
                                        null,
                                        org.apache.batik.util.SVGConstants.
                                          SVG_TYPE_ATTRIBUTE);
                                    if (type.
                                          length(
                                            ) ==
                                          0) {
                                        type =
                                          org.apache.batik.util.SVGConstants.
                                            SVG_SCRIPT_TYPE_DEFAULT_VALUE;
                                    }
                                    if (type.
                                          equals(
                                            org.apache.batik.util.SVGConstants.
                                              SVG_SCRIPT_TYPE_JAVA)) {
                                        try {
                                            java.lang.String href =
                                              org.apache.batik.dom.util.XLinkSupport.
                                              getXLinkHref(
                                                script);
                                            org.apache.batik.util.ParsedURL purl =
                                              new org.apache.batik.util.ParsedURL(
                                              script.
                                                getBaseURI(
                                                  ),
                                              href);
                                            checkCompatibleScriptURL(
                                              type,
                                              purl);
                                            org.apache.batik.bridge.DocumentJarClassLoader cll;
                                            java.net.URL docURL =
                                              null;
                                            try {
                                                docURL =
                                                  new java.net.URL(
                                                    docPURL.
                                                      toString(
                                                        ));
                                            }
                                            catch (java.net.MalformedURLException mue) {
                                                
                                            }
                                            cll =
                                              new org.apache.batik.bridge.DocumentJarClassLoader(
                                                new java.net.URL(
                                                  purl.
                                                    toString(
                                                      )),
                                                docURL);
                                            java.net.URL url =
                                              cll.
                                              findResource(
                                                "META-INF/MANIFEST.MF");
                                            if (url ==
                                                  null) {
                                                continue;
                                            }
                                            java.util.jar.Manifest man =
                                              new java.util.jar.Manifest(
                                              url.
                                                openStream(
                                                  ));
                                            java.lang.String sh;
                                            sh =
                                              man.
                                                getMainAttributes(
                                                  ).
                                                getValue(
                                                  "Script-Handler");
                                            if (sh !=
                                                  null) {
                                                org.apache.batik.script.ScriptHandler h;
                                                h =
                                                  (org.apache.batik.script.ScriptHandler)
                                                    cll.
                                                    loadClass(
                                                      sh).
                                                    newInstance(
                                                      );
                                                if (window ==
                                                      null) {
                                                    window =
                                                      createWindow(
                                                        );
                                                }
                                                h.
                                                  run(
                                                    document,
                                                    window);
                                            }
                                            sh =
                                              man.
                                                getMainAttributes(
                                                  ).
                                                getValue(
                                                  "SVG-Handler-Class");
                                            if (sh !=
                                                  null) {
                                                org.w3c.dom.svg.EventListenerInitializer initializer;
                                                initializer =
                                                  (org.w3c.dom.svg.EventListenerInitializer)
                                                    cll.
                                                    loadClass(
                                                      sh).
                                                    newInstance(
                                                      );
                                                if (window ==
                                                      null) {
                                                    window =
                                                      createWindow(
                                                        );
                                                }
                                                initializer.
                                                  initializeEventListeners(
                                                    (org.w3c.dom.svg.SVGDocument)
                                                      document);
                                            }
                                        }
                                        catch (java.lang.Exception e) {
                                            if (userAgent !=
                                                  null) {
                                                userAgent.
                                                  displayError(
                                                    e);
                                            }
                                        }
                                        continue;
                                    }
                                    org.apache.batik.script.Interpreter interpreter =
                                      getInterpreter(
                                        type);
                                    if (interpreter ==
                                          null)
                                        continue;
                                    try {
                                        java.lang.String href =
                                          org.apache.batik.dom.util.XLinkSupport.
                                          getXLinkHref(
                                            script);
                                        java.lang.String desc =
                                          null;
                                        java.io.Reader reader =
                                          null;
                                        if (href.
                                              length(
                                                ) >
                                              0) {
                                            desc =
                                              href;
                                            org.apache.batik.util.ParsedURL purl =
                                              new org.apache.batik.util.ParsedURL(
                                              script.
                                                getBaseURI(
                                                  ),
                                              href);
                                            checkCompatibleScriptURL(
                                              type,
                                              purl);
                                            java.io.InputStream is =
                                              purl.
                                              openStream(
                                                );
                                            java.lang.String mediaType =
                                              purl.
                                              getContentTypeMediaType(
                                                );
                                            java.lang.String enc =
                                              purl.
                                              getContentTypeCharset(
                                                );
                                            if (enc !=
                                                  null) {
                                                try {
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        is,
                                                        enc);
                                                }
                                                catch (java.io.UnsupportedEncodingException uee) {
                                                    enc =
                                                      null;
                                                }
                                            }
                                            if (reader ==
                                                  null) {
                                                if (APPLICATION_ECMASCRIPT.
                                                      equals(
                                                        mediaType)) {
                                                    if (purl.
                                                          hasContentTypeParameter(
                                                            "version")) {
                                                        continue;
                                                    }
                                                    java.io.PushbackInputStream pbis =
                                                      new java.io.PushbackInputStream(
                                                      is,
                                                      8);
                                                    byte[] buf =
                                                      new byte[4];
                                                    int read =
                                                      pbis.
                                                      read(
                                                        buf);
                                                    if (read >
                                                          0) {
                                                        pbis.
                                                          unread(
                                                            buf,
                                                            0,
                                                            read);
                                                        if (read >=
                                                              2) {
                                                            if (buf[0] ==
                                                                  (byte)
                                                                    255 &&
                                                                  buf[1] ==
                                                                  (byte)
                                                                    254) {
                                                                if (read >=
                                                                      4 &&
                                                                      buf[2] ==
                                                                      0 &&
                                                                      buf[3] ==
                                                                      0) {
                                                                    enc =
                                                                      "UTF32-LE";
                                                                    pbis.
                                                                      skip(
                                                                        4);
                                                                }
                                                                else {
                                                                    enc =
                                                                      "UTF-16LE";
                                                                    pbis.
                                                                      skip(
                                                                        2);
                                                                }
                                                            }
                                                            else
                                                                if (buf[0] ==
                                                                      (byte)
                                                                        254 &&
                                                                      buf[1] ==
                                                                      (byte)
                                                                        255) {
                                                                    enc =
                                                                      "UTF-16BE";
                                                                    pbis.
                                                                      skip(
                                                                        2);
                                                                }
                                                                else
                                                                    if (read >=
                                                                          3 &&
                                                                          buf[0] ==
                                                                          (byte)
                                                                            239 &&
                                                                          buf[1] ==
                                                                          (byte)
                                                                            187 &&
                                                                          buf[2] ==
                                                                          (byte)
                                                                            191) {
                                                                        enc =
                                                                          "UTF-8";
                                                                        pbis.
                                                                          skip(
                                                                            3);
                                                                    }
                                                                    else
                                                                        if (read >=
                                                                              4 &&
                                                                              buf[0] ==
                                                                              0 &&
                                                                              buf[1] ==
                                                                              0 &&
                                                                              buf[2] ==
                                                                              (byte)
                                                                                254 &&
                                                                              buf[3] ==
                                                                              (byte)
                                                                                255) {
                                                                            enc =
                                                                              "UTF-32BE";
                                                                            pbis.
                                                                              skip(
                                                                                4);
                                                                        }
                                                        }
                                                        if (enc ==
                                                              null) {
                                                            enc =
                                                              "UTF-8";
                                                        }
                                                    }
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        pbis,
                                                        enc);
                                                }
                                                else {
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        is);
                                                }
                                            }
                                        }
                                        else {
                                            checkCompatibleScriptURL(
                                              type,
                                              docPURL);
                                            org.apache.batik.bridge.DocumentLoader dl =
                                              bridgeContext.
                                              getDocumentLoader(
                                                );
                                            org.w3c.dom.Element e =
                                              script;
                                            org.w3c.dom.svg.SVGDocument d =
                                              (org.w3c.dom.svg.SVGDocument)
                                                e.
                                                getOwnerDocument(
                                                  );
                                            int line =
                                              dl.
                                              getLineNumber(
                                                script);
                                            desc =
                                              org.apache.batik.bridge.Messages.
                                                formatMessage(
                                                  INLINE_SCRIPT_DESCRIPTION,
                                                  new java.lang.Object[] { d.
                                                    getURL(
                                                      ),
                                                  "<" +
                                                  script.
                                                    getNodeName(
                                                      ) +
                                                  ">",
                                                  new java.lang.Integer(
                                                    line) });
                                            org.w3c.dom.Node n =
                                              script.
                                              getFirstChild(
                                                );
                                            if (n !=
                                                  null) {
                                                java.lang.StringBuffer sb =
                                                  new java.lang.StringBuffer(
                                                  );
                                                while (n !=
                                                         null) {
                                                    if (n.
                                                          getNodeType(
                                                            ) ==
                                                          org.w3c.dom.Node.
                                                            CDATA_SECTION_NODE ||
                                                          n.
                                                          getNodeType(
                                                            ) ==
                                                          org.w3c.dom.Node.
                                                            TEXT_NODE)
                                                        sb.
                                                          append(
                                                            n.
                                                              getNodeValue(
                                                                ));
                                                    n =
                                                      n.
                                                        getNextSibling(
                                                          );
                                                }
                                                reader =
                                                  new java.io.StringReader(
                                                    sb.
                                                      toString(
                                                        ));
                                            }
                                            else {
                                                continue;
                                            }
                                        }
                                        interpreter.
                                          evaluate(
                                            reader,
                                            desc);
                                    }
                                    catch (java.io.IOException e) {
                                        if (userAgent !=
                                              null) {
                                            userAgent.
                                              displayError(
                                                e);
                                        }
                                        return;
                                    }
                                    catch (org.apache.batik.script.InterpreterException e) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "InterpExcept: " +
                                            e);
                                        handleInterpreterException(
                                          e);
                                        return;
                                    }
                                    catch (java.lang.SecurityException e) {
                                        if (userAgent !=
                                              null) {
                                            userAgent.
                                              displayError(
                                                e);
                                        }
                                    }
                                } }
    protected void checkCompatibleScriptURL(java.lang.String scriptType,
                                            org.apache.batik.util.ParsedURL scriptPURL) {
        userAgent.
          checkLoadScript(
            scriptType,
            scriptPURL,
            docPURL);
    }
    public void dispatchSVGLoadEvent() { org.w3c.dom.svg.SVGSVGElement root =
                                           (org.w3c.dom.svg.SVGSVGElement)
                                             document.
                                             getDocumentElement(
                                               );
                                         java.lang.String lang =
                                           root.
                                           getContentScriptType(
                                             );
                                         long documentStartTime =
                                           java.lang.System.
                                           currentTimeMillis(
                                             );
                                         bridgeContext.
                                           getAnimationEngine(
                                             ).
                                           start(
                                             documentStartTime);
                                         dispatchSVGLoad(
                                           root,
                                           true,
                                           lang);
    }
    protected void dispatchSVGLoad(org.w3c.dom.Element elt,
                                   boolean checkCanRun,
                                   java.lang.String lang) {
        for (org.w3c.dom.Node n =
               elt.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                dispatchSVGLoad(
                  (org.w3c.dom.Element)
                    n,
                  checkCanRun,
                  lang);
            }
        }
        org.w3c.dom.events.DocumentEvent de =
          (org.w3c.dom.events.DocumentEvent)
            elt.
            getOwnerDocument(
              );
        org.apache.batik.dom.events.AbstractEvent ev =
          (org.apache.batik.dom.events.AbstractEvent)
            de.
            createEvent(
              "SVGEvents");
        java.lang.String type;
        if (bridgeContext.
              isSVG12(
                )) {
            type =
              "load";
        }
        else {
            type =
              "SVGLoad";
        }
        ev.
          initEventNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            false,
            false);
        org.apache.batik.dom.events.NodeEventTarget t =
          (org.apache.batik.dom.events.NodeEventTarget)
            elt;
        final java.lang.String s =
          elt.
          getAttributeNS(
            null,
            org.apache.batik.util.SVGConstants.
              SVG_ONLOAD_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            t.
              dispatchEvent(
                ev);
            return;
        }
        final org.apache.batik.script.Interpreter interp =
          getInterpreter(
            );
        if (interp ==
              null) {
            t.
              dispatchEvent(
                ev);
            return;
        }
        if (checkCanRun) {
            checkCompatibleScriptURL(
              lang,
              docPURL);
            checkCanRun =
              false;
        }
        org.apache.batik.bridge.DocumentLoader dl =
          bridgeContext.
          getDocumentLoader(
            );
        org.w3c.dom.svg.SVGDocument d =
          (org.w3c.dom.svg.SVGDocument)
            elt.
            getOwnerDocument(
              );
        int line =
          dl.
          getLineNumber(
            elt);
        final java.lang.String desc =
          org.apache.batik.bridge.Messages.
          formatMessage(
            EVENT_SCRIPT_DESCRIPTION,
            new java.lang.Object[] { d.
              getURL(
                ),
            org.apache.batik.util.SVGConstants.
              SVG_ONLOAD_ATTRIBUTE,
            new java.lang.Integer(
              line) });
        org.w3c.dom.events.EventListener l =
          new org.w3c.dom.events.EventListener(
          ) {
            public void handleEvent(org.w3c.dom.events.Event evt) {
                try {
                    java.lang.Object event;
                    if (evt instanceof org.apache.batik.script.ScriptEventWrapper) {
                        event =
                          ((org.apache.batik.script.ScriptEventWrapper)
                             evt).
                            getEventObject(
                              );
                    }
                    else {
                        event =
                          evt;
                    }
                    interp.
                      bindObject(
                        EVENT_NAME,
                        event);
                    interp.
                      bindObject(
                        ALTERNATE_EVENT_NAME,
                        event);
                    interp.
                      evaluate(
                        new java.io.StringReader(
                          s),
                        desc);
                }
                catch (java.io.IOException io) {
                    
                }
                catch (org.apache.batik.script.InterpreterException e) {
                    handleInterpreterException(
                      e);
                }
            }
        };
        t.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            l,
            false,
            null);
        t.
          dispatchEvent(
            ev);
        t.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            l,
            false);
    }
    protected void dispatchSVGZoomEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "zoom");
        }
        else {
            dispatchSVGDocEvent(
              "SVGZoom");
        }
    }
    protected void dispatchSVGScrollEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "scroll");
        }
        else {
            dispatchSVGDocEvent(
              "SVGScroll");
        }
    }
    protected void dispatchSVGResizeEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "resize");
        }
        else {
            dispatchSVGDocEvent(
              "SVGResize");
        }
    }
    protected void dispatchSVGDocEvent(java.lang.String eventType) {
        org.w3c.dom.svg.SVGSVGElement root =
          (org.w3c.dom.svg.SVGSVGElement)
            document.
            getDocumentElement(
              );
        org.w3c.dom.events.EventTarget t =
          root;
        org.w3c.dom.events.DocumentEvent de =
          (org.w3c.dom.events.DocumentEvent)
            document;
        org.apache.batik.dom.events.AbstractEvent ev =
          (org.apache.batik.dom.events.AbstractEvent)
            de.
            createEvent(
              "SVGEvents");
        ev.
          initEventNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            eventType,
            false,
            false);
        t.
          dispatchEvent(
            ev);
    }
    protected void handleInterpreterException(org.apache.batik.script.InterpreterException ie) {
        if (userAgent !=
              null) {
            java.lang.Exception ex =
              ie.
              getException(
                );
            userAgent.
              displayError(
                ex ==
                  null
                  ? ie
                  : ex);
        }
    }
    protected void handleSecurityException(java.lang.SecurityException se) {
        if (userAgent !=
              null) {
            userAgent.
              displayError(
                se);
        }
    }
    protected class Window implements org.apache.batik.script.Window {
        protected org.apache.batik.script.Interpreter
          interpreter;
        protected java.lang.String language;
        public Window(org.apache.batik.script.Interpreter interp,
                      java.lang.String lang) {
            super(
              );
            interpreter =
              interp;
            language =
              lang;
        }
        public java.lang.Object setInterval(final java.lang.String script,
                                            long interval) {
            return null;
        }
        public java.lang.Object setInterval(final java.lang.Runnable r,
                                            long interval) {
            return null;
        }
        public void clearInterval(java.lang.Object interval) {
            
        }
        public java.lang.Object setTimeout(final java.lang.String script,
                                           long timeout) {
            return null;
        }
        public java.lang.Object setTimeout(final java.lang.Runnable r,
                                           long timeout) {
            return null;
        }
        public void clearTimeout(java.lang.Object timeout) {
            
        }
        public org.w3c.dom.Node parseXML(java.lang.String text,
                                         org.w3c.dom.Document doc) {
            return null;
        }
        public void getURL(java.lang.String uri,
                           org.apache.batik.script.Window.URLResponseHandler h) {
            getURL(
              uri,
              h,
              "UTF8");
        }
        public void getURL(java.lang.String uri,
                           org.apache.batik.script.Window.URLResponseHandler h,
                           java.lang.String enc) {
            
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h) {
            postURL(
              uri,
              content,
              h,
              "text/plain",
              null);
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h,
                            java.lang.String mimeType) {
            postURL(
              uri,
              content,
              h,
              mimeType,
              null);
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h,
                            java.lang.String mimeType,
                            java.lang.String fEnc) {
            
        }
        public void alert(java.lang.String message) {
            
        }
        public boolean confirm(java.lang.String message) {
            return false;
        }
        public java.lang.String prompt(java.lang.String message) {
            return null;
        }
        public java.lang.String prompt(java.lang.String message,
                                       java.lang.String defVal) {
            return null;
        }
        public org.apache.batik.bridge.BridgeContext getBridgeContext() {
            return bridgeContext;
        }
        public org.apache.batik.script.Interpreter getInterpreter() {
            return interpreter;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "4tP3/gNsuwvOdysAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "RBM26s5w3sFFWjSdRcqJY788i32849ampM/KZdY0g+rICpxBWUQQvssLQq+h" +
           "ek3DMFGW5OhJ1xnY3Vk1RdHNcDNcRR23x2B9iOLriTTuDJy5IoznSKVcm661" +
           "sdteRs586kSG4ZvJlmEDfmOadjAe9BdhZxRbgUCGCTYIcI9Gpgxd59tz1GhH" +
           "5mAT6SQO9aqIplV8PenZ+JBwuVG/nDakFJISNxj0ygQ3GE3R2pzzaWE678pB" +
           "z2HNqaOQqDkWOXm4kVjdyWarsNmik365G9tqNkumejQsD8o9boSvhhlNNThm" +
           "2rF9vDmh1MWClXwrHm9lUlIVx2d5jvCMaq1JbzwlqYw0dKOvmLFliQSJtFGR" +
           "7HQ2HIe3OsaIDWw/XNQJidwyIzLZoK3JjO+wPCqga6WX2H2c6/sCjg3rbV2U" +
           "A73vw9MNEwpdgclmGT3NpLQqSxjTDKEgAfEWMxL9VZB2Ni6/wDe0MJA7C1JU" +
           "WnV0y20NgjCz7jZFUNZeUk2u2WpzZMLZrUqISlYwYqyA68VMl59z3aTbnuFI" +
           "3OLRUCHaLQvriq43NMvewlohen/sMVJNDed9LNDLG2bc7vc2w3iurBaNbpBN" +
           "8XjmYTV41K7XgE82KUFCulyrj614QmLhqt0qjxdmLVBSyR5sWgixWG/ZrZNN" +
           "Y1Mrt5kAz3hCcRFVTSWkqShWfdkQFMLFbAJytsN60NqS2GDCtmPVHQkYNO4N" +
           "xMFEQDoIQWTNiexgtjYXabbptfBsCMalhxqrwSiFEw1e90Ys5NYZnp5PJd+e" +
           "zxCbWUCSOC37g45XpmuyNOJ4ctEsW62YN93ltuk0py0ZmbLBYKWQvebSpoQp" +
           "5/NzXl03JkhrZmy7jLfyq3zIVV3XQvv4cug2h2RPYtprh4l7Mul2NKg3R5ZW" +
           "g+6oPkn07RVLII1R0/fqWwGlNmOCaikrXW5LiNbh49pWZ3h8HDs9c9um9HSa" +
           "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" +
           "RWCQ5w8N8+ztMcwd+5Cx4Lc/KnKF6P84");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("B+i38+S/nwX0G7cKdAJU+sFDoC++PUB3aHPRg9LZQA8Kl/lOXLrb96KbIP2z" +
           "W0X6AtDpLx8ihW4P0jsLgTtPIT0e14P7z4Gb3+k5uPssuAf33Crc9wCY2CHc" +
           "8u2Be3F3y+dmcPeYHz8H8xN58s4zMT9yq5hfAlhfPcT86u3BfGIV2+G7cg6+" +
           "F/Pk6bh0UQIUdmr5OnjmFtAV3PwUQNU5RNd5m9Ah56DLB/kAAqMne65mhs7N" +
           "4sy7l54HVnB3D/u9txqC5at2/xB2/22C/cPnwG7lyV/Jr1KGnuMXo4ru4b1y" +
           "O+Axh/CY2wPvdCS9wzg4B+MwT4izMJK3gPHJvBDQ7h3zQ4zz24PxpPbCOc8W" +
           "ecKCKAosn+3iZvbhLzeOYpMXzrzAfYN0YQzuFozxA3lhTlLXDo1x7fYbQz3n" +
           "WX5f6eD9celB/fCd+MSNvj1C6ftBmAKn2UVxRwZFvt8b8VFYevyGH+Hsfjgi" +
           "f/bNS/c89ubs3xeXwY9/3HEvXbpHS2z75AXKE3ngxapmFpa6d3ed0i/g+3Hp" +
           "sTOUAyh2mRzFgbeTjw6D75PygNyLz5Nya/BqtpcDTe0yJ0W2cekOIJJns2Ko" +
           "X093+3GPn/SUItC5/L3Mf1zl5L3wfIOt+MHT0WZYsvvJ0zX5c2/2Rz/xzdqn" +
           "dvfSZVvKsryVe+jS3bsr8kWj+Ybas2e2dtTWXdRL33nwF+994Wjn78Gdwnuv" +
           "PaHb0ze/BN4F/FJc287+2WO//EM/9+aXiyuK/xfTYcvYiTYAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rMQdNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A9O1PE52IxanpR43NDhySBVrAEO7r3bg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "nb71QQAA");
}
