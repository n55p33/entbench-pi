package org.apache.batik.bridge.svg12;
public abstract class SVG12BridgeEventSupport extends org.apache.batik.bridge.BridgeEventSupport {
    protected SVG12BridgeEventSupport() { super(); }
    public static void addGVTListener(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Document doc) { org.apache.batik.bridge.UserAgent ua =
                                                                    ctx.
                                                                    getUserAgent(
                                                                      );
                                                                  if (ua !=
                                                                        null) {
                                                                      org.apache.batik.gvt.event.EventDispatcher dispatcher =
                                                                        ua.
                                                                        getEventDispatcher(
                                                                          );
                                                                      if (dispatcher !=
                                                                            null) {
                                                                          final org.apache.batik.bridge.svg12.SVG12BridgeEventSupport.Listener listener =
                                                                            new org.apache.batik.bridge.svg12.SVG12BridgeEventSupport.Listener(
                                                                            ctx,
                                                                            ua);
                                                                          dispatcher.
                                                                            addGraphicsNodeMouseListener(
                                                                              listener);
                                                                          dispatcher.
                                                                            addGraphicsNodeMouseWheelListener(
                                                                              listener);
                                                                          dispatcher.
                                                                            addGraphicsNodeKeyListener(
                                                                              listener);
                                                                          org.w3c.dom.events.EventListener l =
                                                                            new org.apache.batik.bridge.BridgeEventSupport.GVTUnloadListener(
                                                                            dispatcher,
                                                                            listener);
                                                                          org.apache.batik.dom.events.NodeEventTarget target =
                                                                            (org.apache.batik.dom.events.NodeEventTarget)
                                                                              doc;
                                                                          target.
                                                                            addEventListenerNS(
                                                                              org.apache.batik.util.XMLConstants.
                                                                                XML_EVENTS_NAMESPACE_URI,
                                                                              "SVGUnload",
                                                                              l,
                                                                              false,
                                                                              null);
                                                                          storeEventListenerNS(
                                                                            ctx,
                                                                            target,
                                                                            org.apache.batik.util.XMLConstants.
                                                                              XML_EVENTS_NAMESPACE_URI,
                                                                            "SVGUnload",
                                                                            l,
                                                                            false);
                                                                      }
                                                                  }
    }
    protected static class Listener extends org.apache.batik.bridge.BridgeEventSupport.Listener implements org.apache.batik.gvt.event.GraphicsNodeMouseWheelListener {
        protected org.apache.batik.bridge.svg12.SVG12BridgeContext
          ctx12;
        public Listener(org.apache.batik.bridge.BridgeContext ctx,
                        org.apache.batik.bridge.UserAgent u) {
            super(
              ctx,
              u);
            ctx12 =
              (org.apache.batik.bridge.svg12.SVG12BridgeContext)
                ctx;
        }
        public void keyPressed(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            if (!isDown) {
                isDown =
                  true;
                dispatchKeyboardEvent(
                  "keydown",
                  evt);
            }
            if (evt.
                  getKeyChar(
                    ) ==
                  java.awt.event.KeyEvent.
                    CHAR_UNDEFINED) {
                dispatchTextEvent(
                  evt);
            }
        }
        public void keyReleased(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            dispatchKeyboardEvent(
              "keyup",
              evt);
            isDown =
              false;
        }
        public void keyTyped(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            dispatchTextEvent(
              evt);
        }
        protected void dispatchKeyboardEvent(java.lang.String eventType,
                                             org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            org.apache.batik.bridge.FocusManager fmgr =
              context.
              getFocusManager(
                );
            if (fmgr ==
                  null) {
                return;
            }
            org.w3c.dom.Element targetElement =
              (org.w3c.dom.Element)
                fmgr.
                getCurrentEventTarget(
                  );
            if (targetElement ==
                  null) {
                targetElement =
                  context.
                    getDocument(
                      ).
                    getDocumentElement(
                      );
            }
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                targetElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.events.DOMKeyboardEvent keyEvt =
              (org.apache.batik.dom.events.DOMKeyboardEvent)
                d.
                createEvent(
                  "KeyboardEvent");
            java.lang.String modifiers =
              org.apache.batik.dom.util.DOMUtilities.
              getModifiersList(
                evt.
                  getLockState(
                    ),
                evt.
                  getModifiers(
                    ));
            keyEvt.
              initKeyboardEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                eventType,
                true,
                true,
                null,
                mapKeyCodeToIdentifier(
                  evt.
                    getKeyCode(
                      )),
                mapKeyLocation(
                  evt.
                    getKeyLocation(
                      )),
                modifiers);
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    keyEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        protected void dispatchTextEvent(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            org.apache.batik.bridge.FocusManager fmgr =
              context.
              getFocusManager(
                );
            if (fmgr ==
                  null) {
                return;
            }
            org.w3c.dom.Element targetElement =
              (org.w3c.dom.Element)
                fmgr.
                getCurrentEventTarget(
                  );
            if (targetElement ==
                  null) {
                targetElement =
                  context.
                    getDocument(
                      ).
                    getDocumentElement(
                      );
            }
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                targetElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.events.DOMTextEvent textEvt =
              (org.apache.batik.dom.events.DOMTextEvent)
                d.
                createEvent(
                  "TextEvent");
            textEvt.
              initTextEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "textInput",
                true,
                true,
                null,
                java.lang.String.
                  valueOf(
                    evt.
                      getKeyChar(
                        )));
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    textEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        protected int mapKeyLocation(int location) {
            return location -
              1;
        }
        protected static java.lang.String[][]
          IDENTIFIER_KEY_CODES =
          new java.lang.String[256][];
        static { putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_0,
                                      java.awt.event.KeyEvent.
                                        VK_0);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_1,
                                      java.awt.event.KeyEvent.
                                        VK_1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_2,
                                      java.awt.event.KeyEvent.
                                        VK_2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_3,
                                      java.awt.event.KeyEvent.
                                        VK_3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_4,
                                      java.awt.event.KeyEvent.
                                        VK_4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_5,
                                      java.awt.event.KeyEvent.
                                        VK_5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_6,
                                      java.awt.event.KeyEvent.
                                        VK_6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_7,
                                      java.awt.event.KeyEvent.
                                        VK_7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_8,
                                      java.awt.event.KeyEvent.
                                        VK_8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_9,
                                      java.awt.event.KeyEvent.
                                        VK_9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ACCEPT,
                                      java.awt.event.KeyEvent.
                                        VK_ACCEPT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AGAIN,
                                      java.awt.event.KeyEvent.
                                        VK_AGAIN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_A,
                                      java.awt.event.KeyEvent.
                                        VK_A);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALL_CANDIDATES,
                                      java.awt.event.KeyEvent.
                                        VK_ALL_CANDIDATES);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALPHANUMERIC,
                                      java.awt.event.KeyEvent.
                                        VK_ALPHANUMERIC);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALT_GRAPH,
                                      java.awt.event.KeyEvent.
                                        VK_ALT_GRAPH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALT,
                                      java.awt.event.KeyEvent.
                                        VK_ALT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AMPERSAND,
                                      java.awt.event.KeyEvent.
                                        VK_AMPERSAND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_APOSTROPHE,
                                      java.awt.event.KeyEvent.
                                        VK_QUOTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ASTERISK,
                                      java.awt.event.KeyEvent.
                                        VK_ASTERISK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AT,
                                      java.awt.event.KeyEvent.
                                        VK_AT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_BACKSLASH,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_SLASH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_BACKSPACE,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_SPACE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_B,
                                      java.awt.event.KeyEvent.
                                        VK_B);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CANCEL,
                                      java.awt.event.KeyEvent.
                                        VK_CANCEL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CAPS_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_CAPS_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CIRCUMFLEX,
                                      java.awt.event.KeyEvent.
                                        VK_CIRCUMFLEX);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_C,
                                      java.awt.event.KeyEvent.
                                        VK_C);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CLEAR,
                                      java.awt.event.KeyEvent.
                                        VK_CLEAR);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CODE_INPUT,
                                      java.awt.event.KeyEvent.
                                        VK_CODE_INPUT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COLON,
                                      java.awt.event.KeyEvent.
                                        VK_COLON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_ACUTE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ACUTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_BREVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_BREVE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CARON,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CARON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CEDILLA,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CEDILLA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CIRCUMFLEX,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CIRCUMFLEX);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DIERESIS,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_DIAERESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DOT_ABOVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ABOVEDOT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DOUBLE_ACUTE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_DOUBLEACUTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_GRAVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_GRAVE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_IOTA,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_IOTA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_MACRON,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_MACRON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_OGONEK,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_OGONEK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_RING_ABOVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ABOVERING);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_TILDE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_TILDE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMMA,
                                      java.awt.event.KeyEvent.
                                        VK_COMMA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMPOSE,
                                      java.awt.event.KeyEvent.
                                        VK_COMPOSE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CONTROL,
                                      java.awt.event.KeyEvent.
                                        VK_CONTROL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CONVERT,
                                      java.awt.event.KeyEvent.
                                        VK_CONVERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COPY,
                                      java.awt.event.KeyEvent.
                                        VK_COPY);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CUT,
                                      java.awt.event.KeyEvent.
                                        VK_CUT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DELETE,
                                      java.awt.event.KeyEvent.
                                        VK_DELETE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_D,
                                      java.awt.event.KeyEvent.
                                        VK_D);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOLLAR,
                                      java.awt.event.KeyEvent.
                                        VK_DOLLAR);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_E,
                                      java.awt.event.KeyEvent.
                                        VK_E);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_END,
                                      java.awt.event.KeyEvent.
                                        VK_END);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ENTER,
                                      java.awt.event.KeyEvent.
                                        VK_ENTER);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EQUALS,
                                      java.awt.event.KeyEvent.
                                        VK_EQUALS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ESCAPE,
                                      java.awt.event.KeyEvent.
                                        VK_ESCAPE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EURO,
                                      java.awt.event.KeyEvent.
                                        VK_EURO_SIGN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EXCLAMATION,
                                      java.awt.event.KeyEvent.
                                        VK_EXCLAMATION_MARK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F10,
                                      java.awt.event.KeyEvent.
                                        VK_F10);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F11,
                                      java.awt.event.KeyEvent.
                                        VK_F11);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F12,
                                      java.awt.event.KeyEvent.
                                        VK_F12);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F13,
                                      java.awt.event.KeyEvent.
                                        VK_F13);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F14,
                                      java.awt.event.KeyEvent.
                                        VK_F14);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F15,
                                      java.awt.event.KeyEvent.
                                        VK_F15);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F16,
                                      java.awt.event.KeyEvent.
                                        VK_F16);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F17,
                                      java.awt.event.KeyEvent.
                                        VK_F17);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F18,
                                      java.awt.event.KeyEvent.
                                        VK_F18);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F19,
                                      java.awt.event.KeyEvent.
                                        VK_F19);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F1,
                                      java.awt.event.KeyEvent.
                                        VK_F1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F20,
                                      java.awt.event.KeyEvent.
                                        VK_F20);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F21,
                                      java.awt.event.KeyEvent.
                                        VK_F21);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F22,
                                      java.awt.event.KeyEvent.
                                        VK_F22);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F23,
                                      java.awt.event.KeyEvent.
                                        VK_F23);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F24,
                                      java.awt.event.KeyEvent.
                                        VK_F24);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F2,
                                      java.awt.event.KeyEvent.
                                        VK_F2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F3,
                                      java.awt.event.KeyEvent.
                                        VK_F3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F4,
                                      java.awt.event.KeyEvent.
                                        VK_F4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F5,
                                      java.awt.event.KeyEvent.
                                        VK_F5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F6,
                                      java.awt.event.KeyEvent.
                                        VK_F6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F7,
                                      java.awt.event.KeyEvent.
                                        VK_F7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F8,
                                      java.awt.event.KeyEvent.
                                        VK_F8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F9,
                                      java.awt.event.KeyEvent.
                                        VK_F9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FINAL_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_FINAL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FIND,
                                      java.awt.event.KeyEvent.
                                        VK_FIND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F,
                                      java.awt.event.KeyEvent.
                                        VK_F);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_PERIOD);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_WIDTH,
                                      java.awt.event.KeyEvent.
                                        VK_FULL_WIDTH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_G,
                                      java.awt.event.KeyEvent.
                                        VK_G);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_GRAVE,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_QUOTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_GREATER_THAN,
                                      java.awt.event.KeyEvent.
                                        VK_GREATER);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HALF_WIDTH,
                                      java.awt.event.KeyEvent.
                                        VK_HALF_WIDTH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HASH,
                                      java.awt.event.KeyEvent.
                                        VK_NUMBER_SIGN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HELP,
                                      java.awt.event.KeyEvent.
                                        VK_HELP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HIRAGANA,
                                      java.awt.event.KeyEvent.
                                        VK_HIRAGANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_H,
                                      java.awt.event.KeyEvent.
                                        VK_H);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HOME,
                                      java.awt.event.KeyEvent.
                                        VK_HOME);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_I,
                                      java.awt.event.KeyEvent.
                                        VK_I);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_INSERT,
                                      java.awt.event.KeyEvent.
                                        VK_INSERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_INVERTED_EXCLAMATION,
                                      java.awt.event.KeyEvent.
                                        VK_INVERTED_EXCLAMATION_MARK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_HIRAGANA,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_HIRAGANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_KATAKANA,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_KATAKANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_ROMAJI,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_ROMAN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_J,
                                      java.awt.event.KeyEvent.
                                        VK_J);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KANA_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_KANA_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KANJI_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_KANJI);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KATAKANA,
                                      java.awt.event.KeyEvent.
                                        VK_KATAKANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_K,
                                      java.awt.event.KeyEvent.
                                        VK_K);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_BRACE,
                                      java.awt.event.KeyEvent.
                                        VK_BRACELEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT,
                                      java.awt.event.KeyEvent.
                                        VK_LEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_PARENTHESIS,
                                      java.awt.event.KeyEvent.
                                        VK_LEFT_PARENTHESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_SQUARE_BRACKET,
                                      java.awt.event.KeyEvent.
                                        VK_OPEN_BRACKET);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LESS_THAN,
                                      java.awt.event.KeyEvent.
                                        VK_LESS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_L,
                                      java.awt.event.KeyEvent.
                                        VK_L);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_META,
                                      java.awt.event.KeyEvent.
                                        VK_META);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_META,
                                      java.awt.event.KeyEvent.
                                        VK_META);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MINUS,
                                      java.awt.event.KeyEvent.
                                        VK_MINUS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_M,
                                      java.awt.event.KeyEvent.
                                        VK_M);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MODE_CHANGE,
                                      java.awt.event.KeyEvent.
                                        VK_MODECHANGE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_N,
                                      java.awt.event.KeyEvent.
                                        VK_N);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NONCONVERT,
                                      java.awt.event.KeyEvent.
                                        VK_NONCONVERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NUM_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_NUM_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NUM_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_NUM_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_O,
                                      java.awt.event.KeyEvent.
                                        VK_O);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAGE_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_PAGE_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAGE_UP,
                                      java.awt.event.KeyEvent.
                                        VK_PAGE_UP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PASTE,
                                      java.awt.event.KeyEvent.
                                        VK_PASTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAUSE,
                                      java.awt.event.KeyEvent.
                                        VK_PAUSE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_P,
                                      java.awt.event.KeyEvent.
                                        VK_P);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PLUS,
                                      java.awt.event.KeyEvent.
                                        VK_PLUS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PREVIOUS_CANDIDATE,
                                      java.awt.event.KeyEvent.
                                        VK_PREVIOUS_CANDIDATE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PRINT_SCREEN,
                                      java.awt.event.KeyEvent.
                                        VK_PRINTSCREEN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PROPS,
                                      java.awt.event.KeyEvent.
                                        VK_PROPS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Q,
                                      java.awt.event.KeyEvent.
                                        VK_Q);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_QUOTE,
                                      java.awt.event.KeyEvent.
                                        VK_QUOTEDBL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_BRACE,
                                      java.awt.event.KeyEvent.
                                        VK_BRACERIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT,
                                      java.awt.event.KeyEvent.
                                        VK_RIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_PARENTHESIS,
                                      java.awt.event.KeyEvent.
                                        VK_RIGHT_PARENTHESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_SQUARE_BRACKET,
                                      java.awt.event.KeyEvent.
                                        VK_CLOSE_BRACKET);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_R,
                                      java.awt.event.KeyEvent.
                                        VK_R);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ROMAN_CHARACTERS,
                                      java.awt.event.KeyEvent.
                                        VK_ROMAN_CHARACTERS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SCROLL,
                                      java.awt.event.KeyEvent.
                                        VK_SCROLL_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SCROLL,
                                      java.awt.event.KeyEvent.
                                        VK_SCROLL_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SEMICOLON,
                                      java.awt.event.KeyEvent.
                                        VK_SEMICOLON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SEMIVOICED_SOUND,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_SEMIVOICED_SOUND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SHIFT,
                                      java.awt.event.KeyEvent.
                                        VK_SHIFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SHIFT,
                                      java.awt.event.KeyEvent.
                                        VK_SHIFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_S,
                                      java.awt.event.KeyEvent.
                                        VK_S);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SLASH,
                                      java.awt.event.KeyEvent.
                                        VK_SLASH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SPACE,
                                      java.awt.event.KeyEvent.
                                        VK_SPACE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_STOP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_TAB,
                                      java.awt.event.KeyEvent.
                                        VK_TAB);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_T,
                                      java.awt.event.KeyEvent.
                                        VK_T);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_U,
                                      java.awt.event.KeyEvent.
                                        VK_U);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNDERSCORE,
                                      java.awt.event.KeyEvent.
                                        VK_UNDERSCORE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNDO,
                                      java.awt.event.KeyEvent.
                                        VK_UNDO);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNIDENTIFIED,
                                      java.awt.event.KeyEvent.
                                        VK_UNDEFINED);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UP,
                                      java.awt.event.KeyEvent.
                                        VK_UP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_V,
                                      java.awt.event.KeyEvent.
                                        VK_V);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_VOICED_SOUND,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_VOICED_SOUND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_W,
                                      java.awt.event.KeyEvent.
                                        VK_W);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_X,
                                      java.awt.event.KeyEvent.
                                        VK_X);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Y,
                                      java.awt.event.KeyEvent.
                                        VK_Y);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Z,
                                      java.awt.event.KeyEvent.
                                        VK_Z);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_0,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD0);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_1,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_2,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_3,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_4,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_5,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_6,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_7,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_8,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_9,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ASTERISK,
                                      java.awt.event.KeyEvent.
                                        VK_MULTIPLY);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_KP_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_DECIMAL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT,
                                      java.awt.event.KeyEvent.
                                        VK_KP_LEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MINUS,
                                      java.awt.event.KeyEvent.
                                        VK_SUBTRACT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PLUS,
                                      java.awt.event.KeyEvent.
                                        VK_ADD);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT,
                                      java.awt.event.KeyEvent.
                                        VK_KP_RIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SLASH,
                                      java.awt.event.KeyEvent.
                                        VK_DIVIDE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UP,
                                      java.awt.event.KeyEvent.
                                        VK_KP_UP);
        }
        protected static void putIdentifierKeyCode(java.lang.String keyIdentifier,
                                                   int keyCode) {
            if (IDENTIFIER_KEY_CODES[keyCode /
                                       256] ==
                  null) {
                IDENTIFIER_KEY_CODES[keyCode /
                                       256] =
                  (new java.lang.String[256]);
            }
            IDENTIFIER_KEY_CODES[keyCode /
                                   256][keyCode %
                                          256] =
              keyIdentifier;
        }
        protected java.lang.String mapKeyCodeToIdentifier(int keyCode) {
            java.lang.String[] a =
              IDENTIFIER_KEY_CODES[keyCode /
                                     256];
            if (a ==
                  null) {
                return org.apache.batik.dom.events.DOMKeyboardEvent.
                         KEY_UNIDENTIFIED;
            }
            return a[keyCode %
                       256];
        }
        public void mouseWheelMoved(org.apache.batik.gvt.event.GraphicsNodeMouseWheelEvent evt) {
            org.w3c.dom.Document doc =
              context.
              getPrimaryBridgeContext(
                ).
              getDocument(
                );
            org.w3c.dom.Element targetElement =
              doc.
              getDocumentElement(
                );
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                doc;
            org.apache.batik.dom.svg12.SVGOMWheelEvent wheelEvt =
              (org.apache.batik.dom.svg12.SVGOMWheelEvent)
                d.
                createEvent(
                  "WheelEvent");
            wheelEvt.
              initWheelEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "wheel",
                true,
                true,
                null,
                evt.
                  getWheelDelta(
                    ));
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    wheelEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        public void mouseEntered(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getGraphicsNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                new java.awt.geom.Point2D.Float(
                  evt.
                    getX(
                      ),
                  evt.
                    getY(
                      )));
            org.w3c.dom.Element relatedElement =
              getRelatedElement(
                evt);
            int n =
              0;
            if (relatedElement !=
                  null &&
                  targetElement !=
                  null) {
                n =
                  org.apache.batik.bridge.svg12.DefaultXBLManager.
                    computeBubbleLimit(
                      targetElement,
                      relatedElement);
            }
            dispatchMouseEvent(
              "mouseover",
              targetElement,
              relatedElement,
              clientXY,
              evt,
              true,
              n);
        }
        public void mouseExited(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getRelatedNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                clientXY);
            if (lastTargetElement !=
                  null) {
                int n =
                  0;
                if (targetElement !=
                      null) {
                    n =
                      org.apache.batik.bridge.svg12.DefaultXBLManager.
                        computeBubbleLimit(
                          lastTargetElement,
                          targetElement);
                }
                dispatchMouseEvent(
                  "mouseout",
                  lastTargetElement,
                  targetElement,
                  clientXY,
                  evt,
                  true,
                  n);
                lastTargetElement =
                  null;
            }
        }
        public void mouseMoved(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getGraphicsNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                clientXY);
            org.w3c.dom.Element holdLTE =
              lastTargetElement;
            if (holdLTE !=
                  targetElement) {
                if (holdLTE !=
                      null) {
                    int n =
                      0;
                    if (targetElement !=
                          null) {
                        n =
                          org.apache.batik.bridge.svg12.DefaultXBLManager.
                            computeBubbleLimit(
                              holdLTE,
                              targetElement);
                    }
                    dispatchMouseEvent(
                      "mouseout",
                      holdLTE,
                      targetElement,
                      clientXY,
                      evt,
                      true,
                      n);
                }
                if (targetElement !=
                      null) {
                    int n =
                      0;
                    if (holdLTE !=
                          null) {
                        n =
                          org.apache.batik.bridge.svg12.DefaultXBLManager.
                            computeBubbleLimit(
                              targetElement,
                              holdLTE);
                    }
                    dispatchMouseEvent(
                      "mouseover",
                      targetElement,
                      holdLTE,
                      clientXY,
                      evt,
                      true,
                      n);
                }
            }
            dispatchMouseEvent(
              "mousemove",
              targetElement,
              null,
              clientXY,
              evt,
              false,
              0);
        }
        protected void dispatchMouseEvent(java.lang.String eventType,
                                          org.w3c.dom.Element targetElement,
                                          org.w3c.dom.Element relatedElement,
                                          java.awt.Point clientXY,
                                          org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt,
                                          boolean cancelable) {
            dispatchMouseEvent(
              eventType,
              targetElement,
              relatedElement,
              clientXY,
              evt,
              cancelable,
              0);
        }
        protected void dispatchMouseEvent(java.lang.String eventType,
                                          org.w3c.dom.Element targetElement,
                                          org.w3c.dom.Element relatedElement,
                                          java.awt.Point clientXY,
                                          org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt,
                                          boolean cancelable,
                                          int bubbleLimit) {
            if (ctx12.
                  mouseCaptureTarget !=
                  null) {
                org.apache.batik.dom.events.NodeEventTarget net =
                  null;
                if (targetElement !=
                      null) {
                    net =
                      (org.apache.batik.dom.events.NodeEventTarget)
                        targetElement;
                    while (net !=
                             null &&
                             net !=
                             ctx12.
                               mouseCaptureTarget) {
                        net =
                          net.
                            getParentNodeEventTarget(
                              );
                    }
                }
                if (net ==
                      null) {
                    if (ctx12.
                          mouseCaptureSendAll) {
                        targetElement =
                          (org.w3c.dom.Element)
                            ctx12.
                              mouseCaptureTarget;
                    }
                    else {
                        targetElement =
                          null;
                    }
                }
            }
            if (targetElement !=
                  null) {
                java.awt.Point screenXY =
                  evt.
                  getScreenPoint(
                    );
                org.w3c.dom.events.DocumentEvent d =
                  (org.w3c.dom.events.DocumentEvent)
                    targetElement.
                    getOwnerDocument(
                      );
                org.apache.batik.dom.events.DOMMouseEvent mouseEvt =
                  (org.apache.batik.dom.events.DOMMouseEvent)
                    d.
                    createEvent(
                      "MouseEvents");
                java.lang.String modifiers =
                  org.apache.batik.dom.util.DOMUtilities.
                  getModifiersList(
                    evt.
                      getLockState(
                        ),
                    evt.
                      getModifiers(
                        ));
                mouseEvt.
                  initMouseEventNS(
                    org.apache.batik.util.XMLConstants.
                      XML_EVENTS_NAMESPACE_URI,
                    eventType,
                    true,
                    cancelable,
                    null,
                    evt.
                      getClickCount(
                        ),
                    screenXY.
                      x,
                    screenXY.
                      y,
                    clientXY.
                      x,
                    clientXY.
                      y,
                    (short)
                      (evt.
                         getButton(
                           ) -
                         1),
                    (org.w3c.dom.events.EventTarget)
                      relatedElement,
                    modifiers);
                ((org.apache.batik.dom.events.AbstractEvent)
                   mouseEvt).
                  setBubbleLimit(
                    bubbleLimit);
                try {
                    ((org.w3c.dom.events.EventTarget)
                       targetElement).
                      dispatchEvent(
                        mouseEvt);
                }
                catch (java.lang.RuntimeException e) {
                    ua.
                      displayError(
                        e);
                }
                finally {
                    lastTargetElement =
                      targetElement;
                }
            }
            if (ctx12.
                  mouseCaptureTarget !=
                  null &&
                  ctx12.
                    mouseCaptureAutoRelease &&
                  "mouseup".
                  equals(
                    eventType)) {
                ctx12.
                  stopMouseCapture(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kT9Mtq4gtH0zqagMi1Fu4o6iGFpFiIHU");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("t/jESEbDpRE2m83nnssfZ/3SG3vM9lDx9PB4U9EP8dwwPe8FTdHhyXvr4oFp" +
           "/lLjhcP3GS+ceetz6qXj3tGzbfymt1KrTXSg5vsxDrqB5OuGHA49RWW8OFRn" +
           "uqraR9sz8sf2T91uE1LxyP5zH3npZYX9VXj/8DmuHpUuHO4NO9Fk99JufeMW" +
           "g0bxImb3F519d3Vivpvf2xWOSG/1bHrvRtzQ68RNq1mxOaVo89fOeUj9Sl78" +
           "86h0v6VmXKCGoarc8lHqxjOUE99/7gc9RT3dza0shYPjo4eW+uibaqn8568X" +
           "Al8+B/Zv58VvRaW3ANhjMColgDu/9PkTjF+6U4woOD5xiPETPyKMv3cOxq/k" +
           "xatR6SLAmAf3WYC/ewcAizfVHXB8+hDgp94owO4tAe6f8MTzJyi/dg7K/5QX" +
           "X41KjypG6EuRrIPQX3pSoBTxfwbyf7xTyC1wfPkQ8pffHMg3+fQb56D9Zl78" +
           "KaDoI7RTNY1uhfTP7gDpY/nFq+D4+iHSr7/pSLVC4K/OQfpaXvxlVHrQkXzg" +
           "0oEnS0d7q7QTmP/9DmAW2w1+BkTb87u6++IbgHl6Kns9gbwD/NfnAP7bvPhO" +
           "VHrEjyNKAR7N320FADoB+PyMd797p7AhoJt6CFv90Xh3b+/2YPeK1OPvotJj" +
           "O+/mEKfeCerCbCdw//5OqbgNYHqHcL03Cvd1TczoG05IjufnvbeeY6iH8uJi" +
           "VLrkHFdkvM1ZLt+7704t9F5gmcMJef/NnZCPLAS/EQudGOfHzzHO03nxWFR6" +
           "oDAOme+muckyj9+pZa4Bi3z20DKffVMtk6v3ZAHk2XNAlvPiKkhVdiBTI7oJ" +
           "4zN3ivGnAbYvHmL84o8IY/0cjPkCY68CstAC460CHL7Tmfs5AO3bhxC/9UYh" +
           "3prxLhQCF07IKt+Qk0d5gsgHiucc5B/N7KbmvdaRwG4HhZREB5y329+z92Rx" +
           "70zGfe/S80Be6hb2aZ5ju35evDcqPXyUEpwMoDM2fO5ObQjC5K57Dm34/TfH" +
           "hvcWAvcWNizsdFy0C9PkRWd9PKdMzzGEkBfs6zHED9yDc8OmV5BBHy0ej5xY" +
           "/6E+EQArz7ff9JHS7sMa+fMvX7r4+Mv8f95tGTz6+OW+QemiFtv26c2jp84v" +
           "+IGqGYVd79ttJfULS1yPSk+dq2FUuqf4n+PZ+8Cu0jIqPX6bSmABvDs5LQ+u" +
           "Xj4rD9ot/p+WA8vn+0/kQFO7k9MioN5dQCQ/tf0jGyPnb+u+5bcX6W62efvp" +
           "GC4yiId/kMePq5zekp9vhys+PjvauhbvPj+7Ln/h5f7wg99Ff3X3SYBsS9tt" +
           "3srFQene3dcJRaP59rd33ra1o7Yu9J793oNfvO+Zo+cND+4UPhlPp3R7+tb7" +
           "70nHj4od89t/8/hvvfdfvvznxU6r/wdNVrlgFTgAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RPudVs49ZbJ84H8vCnVfE6/8tvxftF5LNx4VAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/hdrajVgNyAAAA==");
}
