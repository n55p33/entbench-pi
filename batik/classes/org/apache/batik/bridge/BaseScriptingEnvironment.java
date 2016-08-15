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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Iz59/7/LQ5lsdysAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "hWG/2rNnq6reE7yaPrcyTpgbobficNytWJHoIeQUyHSm1DBcrDljHZC9eDNb" +
           "JuOmRC2YHmWFzHy5rky4FastOysmpTo9xcgsu25LMcJUSCeVvARxOc1SRu1B" +
           "Q8bVVFRiLuk7Jtn0J5jv9geDvlf38DhinBpHeWK06s1mLin4jifA654R99oC" +
           "NutOehW2TddbokwYvlfv4ow1VRgBb0HipFcFK24/6fXtCjDTzAkmNWseUZPl" +
           "hMlGLsNhssXUrCWlw6jftX131uxoU3jGh1bsLjcoYw5n/YxME8yQILPXFzCf" +
           "UhG9nK1GDM9EYW1qJRwabgaN2ji0UGyOqBjabpQ3qk3g4iTR0fF6viqn5JaZ" +
           "or2l0MG6PmP5Q7HKhxOHQQWa7JvtKjvlZ5ytwDVupUicNZjOO+s5u2Xo2XrJ" +
           "iBsSIcREJ3isxqR8BsvpAC/LA0ErB+Y64joOpzRDfU3hKd3muro7HjDOAqPa" +
           "TN1ZT5J51NVXcrvCzydWc6NvFZ0egxrO2PVra94f6fpqTOMzzKYnRNxtL6ZY" +
           "1KtyuowPu47QmFre0qmSraDHe+TIs0SkrIkkpVqwPu51KLLNyrBmkCHmZQsx" +
           "5sOsrkm4gVTaC3FkVslO2M1WjLdurVoTE/eVCRV5LuXxTawzntqeHPM1EQqn" +
           "ZbJHjFVhHYTlVVZDeZfOakFbMTMvLIekW6lNXIVzxvDAaDBDutWM5+7E6ErU" +
           "RCybc92LNSpz4HDVaPrTYaSTquAalUm/MhISZyS5m+agzWteuYJz1cpoLcyq" +
           "Q4rvs1QYNSp2lxdtpD+c+4MVIzTSDrdOJL+ubsu+rqqkZ+OTOMPUKF0FpMCv" +
           "g0YwLy/KnUEHQUlsUm0NEk+ewpmEGaGJll2Up8gOnFF9a9CbJmwZk8pMOsIM" +
           "lndRy0x8cy0S5cpWQSStVyf6pj6qjkcdX2STtNamxtTAWM0zfgImTGXpuQJa" +
           "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" +
           "MMjzh4Z59vYY5o59yFjw2x8WuUL0f5wD");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("9Nt58t/PAvqNWwXKApW+/xDoC28P0B3aXPSgdDbQg8Jl3opKl3wvvAnSP7tV" +
           "pO8BOv3lQ6Tl24P0zkLgzlNIj8f14L5z4OZ3eg4unQX34O5bhfteABM5hFu9" +
           "PXAv7m753AzuHvPj52B+Ik/eeSbmR24V84sA6yuHmF+5PZhPrGI7fFfOwfdC" +
           "njwdlS6KgMJOLV8Hz9wCuoKbnwKoeofoem8Tuso56PJBPiiD0ZM9VzMD52Zx" +
           "5iXJ88AK7u5hv+9WQ7B81aYOYVNvE+wfPAd2J0/+Sn6VMvAcvxjV2h7ey7cD" +
           "3vgQ3vj2wDsdSe8wDs7ByOQJfhbG/i1gfDIvBLR7x+IQ4+L2YDyp/fycZ8s8" +
           "mYAoCiyf3eJm9uE3N45ik/eceYH7BunCGNwtGOP78sKcpK4dGuPa7TeGes6z" +
           "/L7SwQej0gP64TvxiRt9e4Ti94IwAU6zi+KODFr5Xm/Eh0Hp8Ru+hLP74oj8" +
           "uTcu3/3YG/y/Ly6DH3+54x66dLcW2/bJC5Qn8sCLVc0sLHXP7jqlX8D3o9Jj" +
           "ZygHUOwyOYoDbycfHgbfJ+UBuRf/T8ptwKvZXg40tcucFEmj0h1AJM9mxVC/" +
           "luz24x4/6SlFoPPwdzP/cZWT98LzDbbiC09Hm2Hx7itP1+TPv0ENf/SbjU/v" +
           "7qXLtphleSt306VLuyvyRaP5htqzZ7Z21NZdxItvPfAL97znaOfvgZ3Ce689" +
           "odvTN78EjgF+Ka5tZ//ssV/6gZ994yvFFcX/Cwb8pvyJNgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EEIdNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wI8EbuUl6Ze6PNv5/dmLBu81x43RkWaPm6LDqQLcZ7mz+9uPWZ+HMpa74CJ3" +
       "A3Nw3PqcA+P52VNnsgPZ9w0nm+n3gzzTvqJub3YGB8vbezwPn8yCv5d36A3Z" +
       "7Y8BcxHkXm0I5DccydqZjR+Cv3Pg+tvsyqTKIrZuwH3NnS/y2EVnxAPT4at6" +
       "NNmjWxfY5rg3nFwgWtubHkMfDMfzua5m1O5vvcmtbc3Cahbg27brp+rmmy5l" +
       "rgOu6Y45/iTm3nhl5tQ4ezyZOOYs4rKgnQWdvFO7wN1r8S16cgL+LH1wDOvw" +
       "6rG+Ooutg+trO6xfOwnrTTmS7Hl6ithh4TbPd0Og0qpyufS3b6WnMap1krzC" +
       "Ncr7FnB9fSfv10+S9wY1zqV9xxkkv+1yMe/HyElrTGOT1oWzBZauUeDHwfVH" +
       "O4H/60kCPyB5HphWczMGqbItbXUly6BfG4YHsOGQ7DWxTDcutJoUttWUk1AY" +
       "V4/i7iz2aXB9a4fiW5ehKOQ33snSnsulPZDxrvnRKTKLLB0TbXWNor0OXN/e" +
       "ifbtU0RLrka026JA9TFN3W0DAMPy+GnzPHeQ85js62uU/TFwfWcn+3dOkf2d" +
       "VyP7rYorR/YR0e/PRE9geV9x7X1il3hM2nf9HaR9aSftS6dI+zNXI+0tQNoh" +
       "NyYPhH30Mp63S9d83wTkOyb3z16j3M+A6y92cv/FKXL/wlVpSDbHRJIG/CS/" +
       "8PgpTstYSvKthAvyvxp986sfSz/3ma1TOwdzRlgonrYrdfnGWLbGeeqMddrh" +
       "fsVfdt744p/+d/7tezvH8o5L8d97Fv6DPrjr0OED3kwW+dFjtP/iNdL+enB9" +
       "f9fs90+h/VeuhvY78v0nz1dBeCDuE5epzG6u7R3mPSb/J64of97edtar7Nf3" +
       "c8v06WubrB9cWvKTB44MD+QFVv3JpVU/yQh3r1ogoG53Hzo5pOtoz/7c//jg" +
       "7/78E98AutUv3BRnTiZQlyOeEB1le4jv+8yHXnvHC9/8uXwhB3jl/9EPHn5r" +
       "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" +
       "7Q2X8v1ILncUK7a8rF6NgPhAg5ddulU3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "f7X5g671QQAA");
}
