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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "k3kpg7puAK1ET5EMbCYx/KwyMLh1hWvEnbErI4gnibVa2pozrUFbrECj/obd" +
           "hLXpIhiqmtnkwhiWfBMZhdu53W92Fbke1ck0ms+i3rDS5pr9jV4d2HoVc1Ax" +
           "WDiujcx9zB+2LW+7Qex5oMBuzWwstmR7SUwmwyHjEAEPuaEYbcKJVqdXSN+g" +
           "bVHM7EY4GItkaHkIX4/wrNnOyOYUHnCVNoGbjG+uo2ZDKi+WjqrPGppDBUlr" +
           "I8odvBLV5iTVU9mOTaT2LNZH03kTw0jOpMqrxnYhimxILTKXWLWZagVehq69" +
           "GmNzIc4wYhMbEV5htmUuHZC1aMB5rWVrSXMbJwCz7QqVu+2GM8Y1rFMWm5Si" +
           "V+syNwvm5mhdRwR81JzAqz4NoaNoxVLVuVQxkqYXtZsjcrUmFmEKpikW7QRc" +
           "a5BiycSPVIFwKT/odMvdbIDznaXOwri77FUn0loVQQC67vQ8d8aM53RirMYj" +
           "Y4rZvdlkyuOqhw3olgUnTH3S7mIzRJwmDtto1GR6bHQTkdh2Ba82Go0I3mPG" +
           "6KRqLcywQ9XRfgIcYwOF9V673NkMxqsRHHXsljwSoClU5SOqRkINrVdH5TFE" +
           "MnMg1Y76Srm1rnl0NitLVViR4pkrJSIyHcvNZT0VCZxuzDJqFXMYS8uOLtfc" +
           "zYTQsWDcDVsDKuASakx5dY/YcEuese2FR29XamtWUUya8Gc62yAUK9STKJjQ" +
           "VcqfJ0y4daNVX1G7dXe7RsnU1IRZZyuIuL8xqUGDHo0mArHGmErTNvrBnB1x" +
           "/GLAudaQSlIyIiiEimnBYNg4sdbDWVhV22rQoVdKIJtV2sfFmaeQtZrebqjj" +
           "JNg4o75M+lUEb7D1crOhYE1xPeqhkFv1zCBss0bAm9mmsppVOysGosvaamZJ" +
           "lsDzMUY4s4UKDdDJyAtaHbEMxZG3nXfkQdaIZ3E5cRowJOE9caNtEogMkTVj" +
           "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" +
           "j1uF05UGh/0ZhOl9IXLITSOoyVCMIM15");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("JAmqD8Pws8/mj7N+8fU9ZnuweHp4vKnoB3humJz3gqZo8OS9dfHANH+p8fzh" +
           "+4znz7z1OfXSce/o2Xb3prdS2yg4kPP9GAcjj3cUVfRntiRP7dCXWUWWjaPt" +
           "Gflj+ydvtwmpeGT/2Q+/+JJE/Fp1//A5rhKULh7uDTvpye6lnXvjFoNO8SJm" +
           "9wvOvrs6Ud/N7+0KQyS3eja9dyNu6DXinshpsTmlqPPXz3lI/XKe/POgdJ8u" +
           "p6Qn+74s3fJRamSr0ontP/v9nqKebuZWmuqC4yOHmvrIG6qp/PI3CoEvnQP7" +
           "d/Lkt4PSmwDsBQhDeYA7z/rcCcYv3inGFjg+fojx4z8kjL9/DsYv58krQekS" +
           "wJg791mAv3cHAIs31UNwfOoQ4CdfL8DRLQHun/DEcycov3oOyv+UJ18JSm+V" +
           "VN/hA1EBri/YvCcV/n8G8n+8U8g9cHzpEPKX3hjIN9n06+eg/Uae/Bmg6CO0" +
           "tJwEt0L653eA9JE88xo4vnaI9GtvONJNIfDX5yD9Vp78VVB6wOQdYFLcFvmj" +
           "vVWbE5j//Q5gFtsNfgp423O7svvc64B5eip7LY68A/w35wD+uzz5TlB62AkD" +
           "VAIWzd9teQA6Avj8jHVfvVPYEOibfAhb/uFYd2/v9mD3itDj74PSIzvr5hBp" +
           "+wR1obYTuP9wp1TcBzDtQ7j264X7mibm1usOSI7n5703n6OoB/PkUlC6bB4X" +
           "nNrRWS7fu/dONfQeoJnDCXn/jZ2QjzRUfT0aOlHOj56jnLfnySNB6f5COYN8" +
           "N81Nmnn0TjXzDNDIZw4185k3VDN5954ogDx9DshynlwDocoOZKIGN2F86k4x" +
           "/iTA9oVDjF/4IWFsnoMxX2DsVUAUWmC8lYNX73TmfhZA+/YhxG++Xoi3ZryL" +
           "hcDFE7LKN+TkXh7XxQPJNg/yj2Z2U/Ne70hgt4OCj4MD0t7t79l7orh3JuK+" +
           "R7BtEJdahX7gc3SH5cl7gtJDRyHByQA6o8Nn71SHwE3uunCow++9MTq8pxC4" +
           "p9BhoafjpF+oJk+G7vGcQp+jiGWeEK9FEd93D84Nm15BBH20eDwyYvMH+kQA" +
           "rDwfu+kjpd2HNeLnXrp86dGXmP+82zJ49PHLvXjp0iY0jNObR0+dX3Q8eaMW" +
           "er13t5XUKTRxPSg9eW4Pg9KF4j/Hs/eBXSEhKD16m0JgAbw7OS0Pcq+clQf1" +
           "Fv+n5cDy+b4TOVDV7uS0CCh3FxDJTw3nSMf187d13/Lbi2Q32zx22oeLCOKh" +
           "72fx4yKnt+Tn2+GKj8+Otq6Fu8/ProuffwmbffDV1q/tPgkQDT7L8lou4aV7" +
           "dl8nFJXm29/ecdvajuq6OH76uw984d6njp43PLDr8Ml4OtW3t996//3AdIJi" +
           "x3z2bx797ff8y5f+othp9f8AC0AGkBU4AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ifY7rZx7ymT5wP9eFOq+IV75bfm/G/XjLh4VAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d2cd25fpFWzvjf7owSvddZNTYMOeKe3WdgsZ/1tzKY/lz6vZ4+e2yxSCxHct" +
       "mDrYJmeDPCcFXIpu82Y++TMhCDNTvLo/AwNyVLAuV1dmLRd1L8jK85DKPLC7" +
       "Tey2uJY9S7mIbVhUbhlCv7Clyl9gFw+FEQ7IET/0jx/9xkee+A5Y1wF0Jsp8" +
       "DpbzyIyjdZY2v/+lTzz0mue++6EcrABSMe999cFnMqnkLazOmp3s0c0evX1T" +
       "H8xMpfI8gOCDkMzBRZZya28bzhNftwAMR3s5IfLsle8Yn/re57b53snYPUEs" +
       "f/C5X//x7oef2zmSZT9xQ6J7lGebaedK373nYR967Haz5Bzdf/rCs3/0O89+" +
       "YKvVleM5YwcciT73V//9jd3nv/u1m6Qld5jO/2Fhw7uW/XKAN/c/RJFVFrE4" +
       "S2jF3jT0MVIdTwo4NS6bq1bDHNVgr9SkPNsVuNUgrthJjZhTfcYh7HFNREWh" +
       "BhfX3FoZczW5F2qDYRmvT9Vw3fMiRvFVzxEot9OaanyPWej+1MWJWXdKd0kD" +
       "0Vv1WXuGDe16Z9hrWJKFoA07HacaLIatOlqHhVHUlpEGGkYNZ+l7o6Hl4QFL" +
       "kPGC6A37s7hQ0nhzVGx1pBLCJjweuPPKcqVU0vrINidYdzlyHJYGm4gWBmSy" +
       "knVvwgbVkTiySl0Mn9AWnhoSSS/wuRUwJFkucsWhwJVLJlFMqNGcU73ylOiT" +
       "bEnngpgtyjg3C1ipNU2KM6tjdoQelXaxWN5gw6o2ny+ididE/M4MjRvLNhFu" +
       "FvSm2Jo2VgJZNqweD9JNb6RFJL2kBE52CEoqGiw3WJWlSVUJxO6sStT04maK" +
       "LInVbCNG7sDrYDVOjTcYR5KwPPB5lysb/AxoUq1q40LEcg2MofvGQlBEnGzQ" +
       "c4miyJifTi2JR4tur11siHPc7UgkO61sRgzDYWZ9Oq0FhMnobNmnVpzhBb35" +
       "jCbrUomc6QHKLVDGdDlujM/DwmJhb3yuQRTTYlsneitmpemNvkrTsdWbLvod" +
       "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" +
       "vBjJNyAAAA==");
}
