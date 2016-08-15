package org.apache.batik.swing;
public class JSVGScrollPane extends javax.swing.JPanel {
    protected org.apache.batik.swing.JSVGCanvas canvas;
    protected javax.swing.JPanel horizontalPanel;
    protected javax.swing.JScrollBar vertical;
    protected javax.swing.JScrollBar horizontal;
    protected java.awt.Component cornerBox;
    protected boolean scrollbarsAlwaysVisible = false;
    protected org.apache.batik.swing.JSVGScrollPane.SBListener hsbListener;
    protected org.apache.batik.swing.JSVGScrollPane.SBListener vsbListener;
    protected java.awt.geom.Rectangle2D viewBox = null;
    protected boolean ignoreScrollChange = false;
    public JSVGScrollPane(org.apache.batik.swing.JSVGCanvas canvas) { super(
                                                                        );
                                                                      this.
                                                                        canvas =
                                                                        canvas;
                                                                      canvas.
                                                                        setRecenterOnResize(
                                                                          false);
                                                                      vertical =
                                                                        new javax.swing.JScrollBar(
                                                                          javax.swing.JScrollBar.
                                                                            VERTICAL,
                                                                          0,
                                                                          0,
                                                                          0,
                                                                          0);
                                                                      horizontal =
                                                                        new javax.swing.JScrollBar(
                                                                          javax.swing.JScrollBar.
                                                                            HORIZONTAL,
                                                                          0,
                                                                          0,
                                                                          0,
                                                                          0);
                                                                      horizontalPanel =
                                                                        new javax.swing.JPanel(
                                                                          new java.awt.BorderLayout(
                                                                            ));
                                                                      horizontalPanel.
                                                                        add(
                                                                          horizontal,
                                                                          java.awt.BorderLayout.
                                                                            CENTER);
                                                                      cornerBox =
                                                                        javax.swing.Box.
                                                                          createRigidArea(
                                                                            new java.awt.Dimension(
                                                                              vertical.
                                                                                getPreferredSize(
                                                                                  ).
                                                                                width,
                                                                              horizontal.
                                                                                getPreferredSize(
                                                                                  ).
                                                                                height));
                                                                      horizontalPanel.
                                                                        add(
                                                                          cornerBox,
                                                                          java.awt.BorderLayout.
                                                                            EAST);
                                                                      hsbListener =
                                                                        createScrollBarListener(
                                                                          false);
                                                                      horizontal.
                                                                        getModel(
                                                                          ).
                                                                        addChangeListener(
                                                                          hsbListener);
                                                                      vsbListener =
                                                                        createScrollBarListener(
                                                                          true);
                                                                      vertical.
                                                                        getModel(
                                                                          ).
                                                                        addChangeListener(
                                                                          vsbListener);
                                                                      updateScrollbarState(
                                                                        false,
                                                                        false);
                                                                      setLayout(
                                                                        new java.awt.BorderLayout(
                                                                          ));
                                                                      add(
                                                                        canvas,
                                                                        java.awt.BorderLayout.
                                                                          CENTER);
                                                                      add(
                                                                        vertical,
                                                                        java.awt.BorderLayout.
                                                                          EAST);
                                                                      add(
                                                                        horizontalPanel,
                                                                        java.awt.BorderLayout.
                                                                          SOUTH);
                                                                      canvas.
                                                                        addSVGDocumentLoaderListener(
                                                                          createLoadListener(
                                                                            ));
                                                                      org.apache.batik.swing.JSVGScrollPane.ScrollListener xlistener =
                                                                        createScrollListener(
                                                                          );
                                                                      addComponentListener(
                                                                        xlistener);
                                                                      canvas.
                                                                        addGVTTreeRendererListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addJGVTComponentListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addGVTTreeBuilderListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addUpdateManagerListener(
                                                                          xlistener);
    }
    public boolean getScrollbarsAlwaysVisible() {
        return scrollbarsAlwaysVisible;
    }
    public void setScrollbarsAlwaysVisible(boolean vis) {
        scrollbarsAlwaysVisible =
          vis;
        resizeScrollBars(
          );
    }
    protected org.apache.batik.swing.JSVGScrollPane.SBListener createScrollBarListener(boolean isVertical) {
        return new org.apache.batik.swing.JSVGScrollPane.SBListener(
          isVertical);
    }
    protected org.apache.batik.swing.JSVGScrollPane.ScrollListener createScrollListener() {
        return new org.apache.batik.swing.JSVGScrollPane.ScrollListener(
          );
    }
    protected org.apache.batik.swing.svg.SVGDocumentLoaderListener createLoadListener() {
        return new org.apache.batik.swing.JSVGScrollPane.SVGScrollDocumentLoaderListener(
          );
    }
    public org.apache.batik.swing.JSVGCanvas getCanvas() {
        return canvas;
    }
    class SVGScrollDocumentLoaderListener extends org.apache.batik.swing.svg.SVGDocumentLoaderAdapter {
        public void documentLoadingCompleted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
            org.apache.batik.dom.events.NodeEventTarget root =
              (org.apache.batik.dom.events.NodeEventTarget)
                e.
                getSVGDocument(
                  ).
                getRootElement(
                  );
            root.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                org.apache.batik.util.SVGConstants.
                  SVG_SVGZOOM_EVENT_TYPE,
                new org.w3c.dom.events.EventListener(
                  ) {
                    public void handleEvent(org.w3c.dom.events.Event evt) {
                        if (!(evt.
                                getTarget(
                                  ) instanceof org.w3c.dom.svg.SVGSVGElement))
                            return;
                        org.w3c.dom.svg.SVGSVGElement svg =
                          (org.w3c.dom.svg.SVGSVGElement)
                            evt.
                            getTarget(
                              );
                        scaleChange(
                          svg.
                            getCurrentScale(
                              ));
                    }
                },
                false,
                null);
        }
        public SVGScrollDocumentLoaderListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fYqze5I/suHp/wDT8Nk8tBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xgRe7hFlxUlq8kQvcEkaLeO1rTkdQBhas9EnumKIyxJlaqtCu8BtnXQ17g8t" +
           "U9b6+KCrjxi7ZTfn02WwqHd1f7OMpbKTqGqKVzt8S4pJkxtiYk8zCGfmjQqp" +
           "hM3bYmfQJiQtsd1FqBRWM40YJO58PmGDVJy2GCWK6pvtoBAXSmWd0iV7iW6K" +
           "qF4DU8Krrutbp0AJVaZpNHROamh8WaFWZmUscvMQb2hRrSqAGkE3y7I+d+pE" +
           "feaAtbtM6IqlGPxa46M6ulZUfjpuTVVLb6QiY4cRaSstrh4bA1HYVA3Soc1x" +
           "Kkw2SVhtDpIlOh7SZmvb13uE1BA2hTUtEYV6SVubW8yTO05d7XSiwkpjBuUI" +
           "n7AlpaPQkepOJqWKRfExI3eTZYrKAu8I465HdiJCpeo4y01wCjQmTCnVGo3t" +
           "fFBoMPG82tHxuoU3o6AnVyZiim5iUJTUNLLFtibXxHEfBgTP06SRYbTqzUa8" +
           "nM799cZ2K2ZQDKs0GVoen4BySVnXosFmLE/TDWqXCm4pXLZFYSS2/DFdbXcq" +
           "6jjo2qzQM+TasmGoTa7FVWqFIFq1tgPDGJCku7AVSS5Jy15p7HBW7PSb0nwZ" +
           "EnG0qOgE11HShmwRwVYutKIIUFwR88sLE9jzZsAuCdSGKVCZLmJWQLB8aU0M" +
           "1iZOMjr0uqkRYDVsnWorhxUaXdyvtjeLTqkvi4Jl0yIldYWOZdpFPuKBKke9" +
           "4UKeg5VYKk+nMGOjujVQxEeO6/JhYynOKnRzGm+MuTQHZEXrqV1xiJNiRFnb" +
           "QUte1t36opvGqwJK1IKNo22HWHtkN8rCNm6w22qIGpK49LhExdNixC3dhNS0" +
           "kKjEZWvUn5FOqjoiwyZzV16sWh2ebin8JgU1EvVDwkXj7rzJrJtBZwIPAG97" +
           "W3Y0eMcrO53dkx9Ej64M4KEsm+i/glNJcvMFD8bvOaw5n3+JStyJagWSHbse" +
           "vNW1QH7k+sTTzzwrjz5Z2juo8izgKfvgtuaYTnbuffOtz5bD/ErkuPTwpaf/" +
           "+YH527V3vYLi6sNnmDxL8neHz32l/ybp1/eQ244KETdc1pxGuna6/HDJA0Ho" +
           "2fNTRYgHj9R6OVNXDz5fPFDrF29e4Lzp9pzL7WFnBWcqaOcOFHhQiijdokDu" +
           "R+r+jOufrofjEezmVP2XqMvFWZNdosgnkCHNrCBiggDs7qqmJyyPg6flyNHl" +
           "Y5N0Xu6gfKoeBlX/MhX8Q3Hf+L+6D4DWdf8NN4y7WzHpM89evvP1z7J/lVe8" +
           "j26uLtLInUpomifLSyf6t7seUPRcOxd3xSY3//v5ALnv5hwFyIX8P2f86R30" +
           "ewPkylloCJf/n4T7pQC5dAwH/WfXOQnyKwFyGwTJur/qHiqn8kpsoS0LbgC8" +
           "5Nxp9z7awXtfbgdPRITHT7lyfgV86Hbh7hL4uvTZZynm3S/UP7mr2EumkKYZ" +
           "lTtp5I7d5cGR6z56S2qHtG4nnnjx7s9dfONhjLl7x/CxQ53g7eGbl8Rxyw3y" +
           "Inb6h6///bf+9rPfzAtp/wMWik5Bmx8AAA==");
    }
    public void reset() { viewBox = null;
                          updateScrollbarState(
                            false,
                            false);
                          revalidate(); }
    protected void setScrollPosition() { checkAndSetViewBoxRect(
                                           );
                                         if (viewBox ==
                                               null)
                                             return;
                                         java.awt.geom.AffineTransform crt =
                                           canvas.
                                           getRenderingTransform(
                                             );
                                         java.awt.geom.AffineTransform vbt =
                                           canvas.
                                           getViewBoxTransform(
                                             );
                                         if (crt ==
                                               null)
                                             crt =
                                               new java.awt.geom.AffineTransform(
                                                 );
                                         if (vbt ==
                                               null)
                                             vbt =
                                               new java.awt.geom.AffineTransform(
                                                 );
                                         java.awt.Rectangle r2d =
                                           vbt.
                                           createTransformedShape(
                                             viewBox).
                                           getBounds(
                                             );
                                         int tx =
                                           0;
                                         int ty =
                                           0;
                                         if (r2d.
                                               x <
                                               0)
                                             tx -=
                                               r2d.
                                                 x;
                                         if (r2d.
                                               y <
                                               0)
                                             ty -=
                                               r2d.
                                                 y;
                                         int deltaX =
                                           horizontal.
                                           getValue(
                                             ) -
                                           tx;
                                         int deltaY =
                                           vertical.
                                           getValue(
                                             ) -
                                           ty;
                                         crt.
                                           preConcatenate(
                                             java.awt.geom.AffineTransform.
                                               getTranslateInstance(
                                                 -deltaX,
                                                 -deltaY));
                                         canvas.
                                           setRenderingTransform(
                                             crt);
    }
    protected class SBListener implements javax.swing.event.ChangeListener {
        protected boolean inDrag = false;
        protected int startValue;
        protected boolean isVertical;
        public SBListener(boolean vertical) {
            super(
              );
            isVertical =
              vertical;
        }
        public synchronized void stateChanged(javax.swing.event.ChangeEvent e) {
            if (ignoreScrollChange)
                return;
            java.lang.Object src =
              e.
              getSource(
                );
            if (!(src instanceof javax.swing.BoundedRangeModel))
                return;
            int val =
              isVertical
              ? vertical.
              getValue(
                )
              : horizontal.
              getValue(
                );
            javax.swing.BoundedRangeModel brm =
              (javax.swing.BoundedRangeModel)
                src;
            if (brm.
                  getValueIsAdjusting(
                    )) {
                if (!inDrag) {
                    inDrag =
                      true;
                    startValue =
                      val;
                }
                else {
                    java.awt.geom.AffineTransform at;
                    if (isVertical) {
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              0,
                              startValue -
                                val);
                    }
                    else {
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              startValue -
                                val,
                              0);
                    }
                    canvas.
                      setPaintingTransform(
                        at);
                }
            }
            else {
                if (inDrag) {
                    inDrag =
                      false;
                    if (val ==
                          startValue) {
                        canvas.
                          setPaintingTransform(
                            new java.awt.geom.AffineTransform(
                              ));
                        return;
                    }
                }
                setScrollPosition(
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
           "80d2eeG/7rdu1x4ZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "k7/z7Lfy0uD/AoKNcnhiIwAA");
    }
    protected class ScrollListener extends java.awt.event.ComponentAdapter implements org.apache.batik.swing.gvt.JGVTComponentListener, org.apache.batik.swing.svg.GVTTreeBuilderListener, org.apache.batik.swing.gvt.GVTTreeRendererListener, org.apache.batik.bridge.UpdateManagerListener {
        protected boolean isReady = false;
        public void componentTransformChanged(java.awt.event.ComponentEvent evt) {
            if (isReady)
                resizeScrollBars(
                  );
        }
        public void componentResized(java.awt.event.ComponentEvent evt) {
            if (isReady)
                resizeScrollBars(
                  );
        }
        public void gvtBuildStarted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            isReady =
              false;
            updateScrollbarState(
              false,
              false);
        }
        public void gvtBuildCompleted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            isReady =
              true;
            viewBox =
              null;
        }
        public void gvtRenderingCompleted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            if (viewBox ==
                  null) {
                resizeScrollBars(
                  );
                return;
            }
            java.awt.geom.Rectangle2D newview =
              getViewBoxRect(
                );
            if (newview.
                  getX(
                    ) !=
                  viewBox.
                  getX(
                    ) ||
                  newview.
                  getY(
                    ) !=
                  viewBox.
                  getY(
                    ) ||
                  newview.
                  getWidth(
                    ) !=
                  viewBox.
                  getWidth(
                    ) ||
                  newview.
                  getHeight(
                    ) !=
                  viewBox.
                  getHeight(
                    )) {
                viewBox =
                  newview;
                resizeScrollBars(
                  );
            }
        }
        public void updateCompleted(org.apache.batik.bridge.UpdateManagerEvent e) {
            if (viewBox ==
                  null) {
                resizeScrollBars(
                  );
                return;
            }
            java.awt.geom.Rectangle2D newview =
              getViewBoxRect(
                );
            if (newview.
                  getX(
                    ) !=
                  viewBox.
                  getX(
                    ) ||
                  newview.
                  getY(
                    ) !=
                  viewBox.
                  getY(
                    ) ||
                  newview.
                  getWidth(
                    ) !=
                  viewBox.
                  getWidth(
                    ) ||
                  newview.
                  getHeight(
                    ) !=
                  viewBox.
                  getHeight(
                    )) {
                viewBox =
                  newview;
                resizeScrollBars(
                  );
            }
        }
        public void gvtBuildCancelled(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            
        }
        public void gvtBuildFailed(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            
        }
        public void gvtRenderingPrepare(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingStarted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingCancelled(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingFailed(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void managerStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerSuspended(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerResumed(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerStopped(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void updateStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void updateFailed(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public ScrollListener() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "g6O7VYGr7XRcgoX+QoOdXjhLRFRymPFoPct0a9MKYcvNaH/TnNj2SGC0wGkN" +
           "WdOzMol3qXl/utO6/SWScxhHxpX1El9NYCYjdh6qyRw2bnQm41QVJzoCW62Y" +
           "6NfiNopKSpaYeIZzlmnDfarbQ/w+WllIEdNBu9tWJgwXSKDrvLXaNftDjw9Y" +
           "aU6G4yU6me7mTGs52rZFwXHNvNbHmGgbaI20nmKL2g5XUL8x6m6IaIH3ulU8" +
           "JmtJBLOpogpqBW1LGOU7VXqM+0STE6XJiqFaSjpTxNrEr+9iDPOzjJzHuGHB" +
           "264sY3htt2u1TE3f5p2kE8EtbDhUmhV2ZtSwWaQ6tW2uBmmc5TWlgg/7WoKs" +
           "IznextIuszxOoZqNCj5gfL+7hb3hcLqur4P1tAr8oyYFg6W9Yyt9dAUAJNHa" +
           "qGmuVDXndNJIpl4QVv2ph5ENvzLz+pLKwxVs7Xfw6UDhyE1lRYmySczjGhUl" +
           "S81Slwt/tna38XKEyJaDcHQIz8fsPG9V/Jzj4cTlmEiXcrXfI6gVmKy21BIx" +
           "N2OJnE176qAzFEhts5Q6JivW5bbosnU0GXX4ZJlVJj1dlqu0kZnbdhsRGkpA" +
           "zDxbnSHD1YihkFnQif05F7DtnLHRXhaxm+Zw14d1pQ1mRJTeSXjcpeMQa0T9" +
           "jldb4e10FqABHYxtHV5NkPEcS9Ao0zNjEMmjqLP1iFjGQb1FLbJtq2Ohdabr" +
           "wPA0bMIViWu0m9kgsWb8TsC2vD5Z6PLK31JZ5AZuzTKcRq3D2BE3wkKXwJYr" +
           "a9pcCss0pJbtse4OFGM81mp0knJDw6JRfjtWzPmAGXXZVGgOOWue7YbcZMZV" +
           "MRJFmqjT13YSz5iDWMPFltama5hrY05FhNFqJ8/62y7QcqebbQwxA62aE643" +
           "mq/wNT7KWpaFG1JzUl3QU0HJBEWXGZjpBwLWs6PWop6QFYOp9tpKz2a5XWKx" +
           "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" +
           "8WOYaRwWA3sW6BsetngzQD9/BPTzNwko");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("fg7Q4jDIQf1kPME7R+pdBbNxI2B+4QjmF24STPIcmP2iee602wZheBXMNzzU" +
           "9GZgfvEI5hdvEkz+HJhC0TAJdO++Drx2cLI3AuWXjlB+6Sah/JFzUD5fNIsE" +
           "umeP8pqJVvpuQObAMa48QF6SgCL9PW/q9HkcQY9e9XuW/W8w1M+9fPHOR16e" +
           "/tvywPXl30ncxUB3Gqnrnj7deOr69jDSDbu01F37s45hidxKoIevrVEC3VZ+" +
           "FoofmHtqB+Svs9SArvw8Tecn0N0ndAl0+/7iNMk6gW4BJMVlFB4b58nrLfu0" +
           "NTlM9Cjfv+s8etqVyvLmwTcanMsspw9nFyt05Y+LjlfT0v3Pi55XX32ZHv3Y" +
           "681f2R8OV115tyuk3MlAd+zPqZdCixW5p64r7VjW7YOnv33f5+96z/HS4X17" +
           "hU/c+pRuT1779DXphUl5Xnr3W4/8s/d96uU/LU8F/n81vZ9O9TUAAA==");
    }
    protected void resizeScrollBars() { ignoreScrollChange =
                                          true;
                                        checkAndSetViewBoxRect(
                                          );
                                        if (viewBox ==
                                              null)
                                            return;
                                        java.awt.geom.AffineTransform vbt =
                                          canvas.
                                          getViewBoxTransform(
                                            );
                                        if (vbt ==
                                              null)
                                            vbt =
                                              new java.awt.geom.AffineTransform(
                                                );
                                        java.awt.Rectangle r2d =
                                          vbt.
                                          createTransformedShape(
                                            viewBox).
                                          getBounds(
                                            );
                                        int maxW =
                                          r2d.
                                            width;
                                        int maxH =
                                          r2d.
                                            height;
                                        int tx =
                                          0;
                                        int ty =
                                          0;
                                        if (r2d.
                                              x >
                                              0)
                                            maxW +=
                                              r2d.
                                                x;
                                        else
                                            tx -=
                                              r2d.
                                                x;
                                        if (r2d.
                                              y >
                                              0)
                                            maxH +=
                                              r2d.
                                                y;
                                        else
                                            ty -=
                                              r2d.
                                                y;
                                        java.awt.Dimension vpSize =
                                          updateScrollbarVisibility(
                                            tx,
                                            ty,
                                            maxW,
                                            maxH);
                                        vertical.
                                          setValues(
                                            ty,
                                            vpSize.
                                              height,
                                            0,
                                            maxH);
                                        horizontal.
                                          setValues(
                                            tx,
                                            vpSize.
                                              width,
                                            0,
                                            maxW);
                                        vertical.
                                          setBlockIncrement(
                                            (int)
                                              (0.9F *
                                                 vpSize.
                                                   height));
                                        horizontal.
                                          setBlockIncrement(
                                            (int)
                                              (0.9F *
                                                 vpSize.
                                                   width));
                                        vertical.
                                          setUnitIncrement(
                                            (int)
                                              (0.2F *
                                                 vpSize.
                                                   height));
                                        horizontal.
                                          setUnitIncrement(
                                            (int)
                                              (0.2F *
                                                 vpSize.
                                                   width));
                                        doLayout(
                                          );
                                        horizontalPanel.
                                          doLayout(
                                            );
                                        horizontal.
                                          doLayout(
                                            );
                                        vertical.
                                          doLayout(
                                            );
                                        ignoreScrollChange =
                                          false;
    }
    protected java.awt.Dimension updateScrollbarVisibility(int tx,
                                                           int ty,
                                                           int maxW,
                                                           int maxH) {
        java.awt.Dimension vpSize =
          canvas.
          getSize(
            );
        int maxVPW =
          vpSize.
            width;
        int minVPW =
          vpSize.
            width;
        int maxVPH =
          vpSize.
            height;
        int minVPH =
          vpSize.
            height;
        if (vertical.
              isVisible(
                )) {
            maxVPW +=
              vertical.
                getPreferredSize(
                  ).
                width;
        }
        else {
            minVPW -=
              vertical.
                getPreferredSize(
                  ).
                width;
        }
        if (horizontalPanel.
              isVisible(
                )) {
            maxVPH +=
              horizontal.
                getPreferredSize(
                  ).
                height;
        }
        else {
            minVPH -=
              horizontal.
                getPreferredSize(
                  ).
                height;
        }
        boolean hNeeded;
        boolean vNeeded;
        java.awt.Dimension ret =
          new java.awt.Dimension(
          );
        if (scrollbarsAlwaysVisible) {
            hNeeded =
              maxW >
                minVPW;
            vNeeded =
              maxH >
                minVPH;
            ret.
              width =
              minVPW;
            ret.
              height =
              minVPH;
        }
        else {
            hNeeded =
              maxW >
                maxVPW ||
                tx !=
                0;
            vNeeded =
              maxH >
                maxVPH ||
                ty !=
                0;
            if (vNeeded &&
                  !hNeeded)
                hNeeded =
                  maxW >
                    minVPW;
            else
                if (hNeeded &&
                      !vNeeded)
                    vNeeded =
                      maxH >
                        minVPH;
            ret.
              width =
              hNeeded
                ? minVPW
                : maxVPW;
            ret.
              height =
              vNeeded
                ? minVPH
                : maxVPH;
        }
        updateScrollbarState(
          hNeeded,
          vNeeded);
        return ret;
    }
    protected void updateScrollbarState(boolean hNeeded,
                                        boolean vNeeded) {
        horizontal.
          setEnabled(
            hNeeded);
        vertical.
          setEnabled(
            vNeeded);
        if (scrollbarsAlwaysVisible) {
            horizontalPanel.
              setVisible(
                true);
            vertical.
              setVisible(
                true);
            cornerBox.
              setVisible(
                true);
        }
        else {
            horizontalPanel.
              setVisible(
                hNeeded);
            vertical.
              setVisible(
                vNeeded);
            cornerBox.
              setVisible(
                hNeeded &&
                  vNeeded);
        }
    }
    protected void checkAndSetViewBoxRect() {
        if (viewBox !=
              null)
            return;
        viewBox =
          getViewBoxRect(
            );
    }
    protected java.awt.geom.Rectangle2D getViewBoxRect() {
        org.w3c.dom.svg.SVGDocument doc =
          canvas.
          getSVGDocument(
            );
        if (doc ==
              null)
            return null;
        org.w3c.dom.svg.SVGSVGElement el =
          doc.
          getRootElement(
            );
        if (el ==
              null)
            return null;
        java.lang.String viewBoxStr =
          el.
          getAttributeNS(
            null,
            org.apache.batik.util.SVGConstants.
              SVG_VIEW_BOX_ATTRIBUTE);
        if (viewBoxStr.
              length(
                ) !=
              0) {
            float[] rect =
              org.apache.batik.bridge.ViewBox.
              parseViewBoxAttribute(
                el,
                viewBoxStr,
                null);
            return new java.awt.geom.Rectangle2D.Float(
              rect[0],
              rect[1],
              rect[2],
              rect[3]);
        }
        org.apache.batik.gvt.GraphicsNode gn =
          canvas.
          getGraphicsNode(
            );
        if (gn ==
              null)
            return null;
        java.awt.geom.Rectangle2D bounds =
          gn.
          getBounds(
            );
        if (bounds ==
              null)
            return null;
        return (java.awt.geom.Rectangle2D)
                 bounds.
                 clone(
                   );
    }
    public void scaleChange(float scale) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4tOP/gfUvGKDtSwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1tnSXQdHttdcajve6cXjB7UXfCWMfHt+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7Lj2yQPOPpJz7KdAenWPs6+efPd8uHbXf/H83t3an3LX4Bun1H0zz/5lWHpi" +
       "rYTM9c+dirfXh8LzG2/1evToFEXBrx+/FoOB9Noe2tfuDNozhw2iosG/OwXy" +
       "t/Ps3wDIwQ0hX/dVcexo8iEbvnUbbMgvBpVgkL68x4Yv3yobujfHht8/hQ3/" +
       "Oc++E5Yek3xFDJWDs+Rjx0CHeL97G3ifzAvzA5Y39vC+cWfwHoXzw1Pq/nue" +
       "fT8svf0o1JNnd+hNnt1d27ngzx/eBn/emxf+BZC+usefr955/vzpjevOFFP9" +
       "77B0acefkSPKN8udIF5fAQwCIWFkKXaYd1X8a7nzJ7fBnUfzwqdB+toed752" +
       "Z4zGUQ48cEpdfpnqzHngooCJxA+vtRyAO3Pv7VrEx0D69h64b995cI+fUvdE" +
       "nj0Slu7xFWAO8xa/ewjs7bcBrDhUfQ9I39sD9r07LtNnLp9S9548expERAdW" +
       "fnrksuQRkM/cLsjnAb1f3/Xd/d5ZkPApddU8K4eli2D1tOzQhgcnML7/NjA+" +
       "nhcC433mj/Yw/tGdwXh30eDu67nau7TiNs6ZDx5mBdwPnMKKVp5hYemdkSsf" +
       "2Hjg2AuPrplamO6bssOrPx0N2KxgP0IsONW4XWnol0pnK7u+u9/b59TZosHZ" +
       "/N/iFkHh28+MT2HGJM9I4PBOMCP/jkQ5IRv920VcBrR19xB377z886fUfTjP" +
       "5mHpUeCWJKNly4wScrsLI/nNkBNI3/Ja3ClIn8gLgZ8+O9lDOrnzSJVT6vJL" +
       "CmdeCksPrq9B+DcPEYq364lyhMYeQuNWEZ4am19Pz+9RTUcMC3zeKdjjPAMb" +
       "r/sDSTSVwys1R5bWuhXgCWDj8aguvw7++DUfZe0+JJJ+5fWH7n3sdfbbxUcE" +
       "Bx/73Dcq3atGpnn0Tu6R53Our6hawZD7djd03QLLy0BYrx9KAXYUvzm5Zz6+" +
       "a/0JYNpPtgbtit+j7f5yWLpw2C4snds9HG3yaWBWQZP88TPFek6T3Zo8flQc" +
       "imDt0lsx88hG/93HtufF52/7W+lo9wHcVekrrw+on/lR/cu7rxkkU8yyfJR7" +
       "R6Xzuw8rikHz7fizNxxtf6xz5As/fvBX73t+/9XBgzuCD0XzCG1PX//Tga7l" +
       "hsVl/+xrj331A7/4+u8Vd47+H3uvLWyXOAAA");
}
