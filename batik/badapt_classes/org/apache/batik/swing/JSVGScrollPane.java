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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "PsXZPckf2fD0fwCtfSwktBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5ceuB291LVAcuT7x9DPPqswnK3sHVZ45OGUf3NYc08nPvW+49dlyWFyJHJce" +
           "vvT0Pz0we4vxjpdRXH34DJNnSf7O8Lmv9F+v/NoedNtRIeKGy5rTSNdOlx8u" +
           "BVoUB87sVBHiwSO1Xs7V1QPPFw/U+sWbFzhvuj3nCnvYWcGZCtq5AwUelCIq" +
           "tyiQh4m+P+X7p+vheAK6BdXwRepyad7klyjqCWRAMy+IWFqk7e6qJicsjwen" +
           "5cQ11WOTdF/qoHyqHgZU/xIV/ENxn/hf3QcA67r/hhvG3a2Y8plnL9/52me5" +
           "vywq3kc3Vxdp6M5lbFkny0sn+rd7gbY0C+1c3BWbvOLvPRF03805iqALxX/B" +
           "+NM76PdG0JWz0ACu+D8J94sRdOkYDvjPrnMS5Jcj6DYAknd/xTtUTvXl2AKm" +
           "Sl6kBdm50+59tIP3vtQOnogIj59y5eIK+NDt4t0l8HXls89So3e+UP/krmKv" +
           "WNJ2m1O5k4bu2F0eHLnuo7ekdkjrduLJH979uYtPHMaYu3cMHzvUCd4evnlJ" +
           "HLe9qChib//gtb/3pt969ptFIe1/AJ0w6DSbHwAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dnnhv1gMYdseGQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vOf3n/ydZ7+ZlwX/FywSKyFeIwAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVaf3AU1R1/d/lJyG8IIJIAMTBDxDuxWrWhVIgJBC+QJpja" +
           "IITN3rtkYW933X2bXKIUdcYRO9VaC2it8heKIAJirf2lg+P4a7Q/VKq1rdrW" +
           "ztQftZXpVDul1n6/b3dv9/ZuL9xMLzN5t/f2fb/vfT/v+/18v+92j3xEygyd" +
           "tFCFRdikRo1Il8L6BN2g8U5ZMIxN0Dcs3l0i/GPrexsuD5PyIVI7Jhi9omDQ" +
           "bonKcWOINEuKwQRFpMYGSuMo0adTg+rjApNUZYg0SUZPUpMlUWK9apzigEFB" +
           "j5EGgTFdGjEZ7bEVMNIcg5VE+Uqiq/23O2KkWlS1SXf4PM/wTs8dHJl05zIY" +
           "qY9tF8aFqMkkORqTDNaR0sn5mipPjsoqi9AUi2yXL7EhWB+7JAuC1uN1n5y5" +
           "c6yeQzBLUBSVcfOMfmqo8jiNx0id29sl06RxHfkGKYmRmZ7BjLTFnEmjMGkU" +
           "JnWsdUfB6muoYiY7VW4OczSVayIuiJHFmUo0QReStpo+vmbQUMls27kwWLso" +
           "ba1lZZaJe8+P7rl7a/2JElI3ROokZQCXI8IiGEwyBIDS5AjVjdXxOI0PkQYF" +
           "NnuA6pIgS1P2Tjca0qgiMBO234EFO02N6nxOFyvYR7BNN0Wm6mnzEtyh7G9l" +
           "CVkYBVvnuLZaFnZjPxhYJcHC9IQAfmeLlO6QlDgjC/0SaRvbroIBIFqRpGxM" +
           "TU9VqgjQQRotF5EFZTQ6AK6njMLQMhUcUGdkfqBSxFoTxB3CKB1Gj/SN67Nu" +
           "wagZHAgUYaTJP4xrgl2a79slz/58tGHlHdcr65QwCcGa41SUcf0zQajFJ9RP" +
           "E1SnEAeWYHV7bJ8w58ndYUJgcJNvsDXmiRtOX7G85eQL1phzc4zZOLKdimxY" +
           "PDBS+8qCzmWXl+AyKjXVkHDzMyznUdZn3+lIacAwc9Ia8WbEuXmy/7mv33iY" +
           "fhgmVT2kXFRlMwl+1CCqSU2Sqb6WKlQXGI33kBlUiXfy+z2kAq5jkkKt3o2J" +
           "hEFZDymVeVe5yr8DRAlQgRBVwbWkJFTnWhPYGL9OaYSQWvgnqwkJjRH+F0pg" +
           "y8g10TE1SaOCKCiSokb7dBXtN6LAOCOA7Vh0BLx+R9RQTR1cMKrqo1EB/GCM" +
           "OjcmwIOi6wcG1w6IuirLfYJCI+hhWhF1p9CuWROhEEC+wB/wMsTKOlWOU31Y" +
           "3GOu6Tp9dPgly5kwAGxEGLkYpotY00X4dBE+XSRzujbrErkUN4mEQnzS2bgK" +
           "a49hh3ZArMOA6mUDW9Zv291aAs6lTZQiyDC0NSPpdLqE4LD4sHissWZq8dsr" +
           "ngmT0hhpFERmCjLmkNX6KLCTuMMO4OoRSEduVljkyQqYznRVpHEgpaDsYGup" +
           "VMepjv2MzPZocHIWRmc0OGPkXD85ec/ETYO7LgyTcGYiwCnLgMNQvA/pO03T" +
           "bX4CyKW37tb3Pjm2b6fqUkFGZnESYpYk2tDqdws/PMNi+yLh8eEnd7Zx2GcA" +
           "VTMBQgtYsMU/RwbTdDisjbZUgsEJVU8KMt5yMK5iY7o64fZwf23ApslyXXQh" +
           "3wI54X95QLv/N794/wscSSc31HmS+gBlHR4+QmWNnHkaXI/cpFMK4966p++7" +
           "ez+6dTN3RxhxXq4J27DtBB6C3QEEb3nhujffefvAqbDrwozM0HSVQeDSeIqb" +
           "M/tz+AvB/3/xH2kEOyw6aey0OW1RmtQ0nHypuzygNxm0oX+0Xa2AJ0oJSRiR" +
           "KYbQf+qWrHj8r3fUWzsuQ4/jMMunV+D2n7OG3PjS1k9buJqQiOnVhdAdZnH2" +
           "LFfzal0XJnEdqZtebf7e88L9wP7AuIY0RTmJEg4J4Xt4CcfiQt5e7Lt3KTZL" +
           "DK+bZ0aSpwwaFu889XHN4MdPnearzayjvFvfK2gdliNZuwCT8RmhCUk2qfNP" +
           "vDtHw3ZuCtYw189V6wRjDJRdfHLDtfXyyTMw7RBMKwIFGxt1oM1UhjfZo8sq" +
           "fvv0M3O2vVJCwt2kSlaFeLfAY47MAGenxhgwbkr7yhXWQiYqoanneJAshLI6" +
           "cBcW5t7frqTG+I5M/WjuD1Ye3P8290zN0nFummQXZJAsL9ndOD/82qW/Pvid" +
           "fRNW0l8WTG4+uXn/3iiP3Pynf2XtC6e1HAWJT34oeuS++Z2rPuTyLr+gdFsq" +
           "O3EBR7uyFx1O/jPcWv5smFQMkXrRLpEHBdnE0B6CstBw6mYoozPuZ5Z4Vj3T" +
           "kebPBX5u80zrZzY3YcI1jsbrGp8PNuIWtsM2bLd9cLvfB0OEX6znIkt5uwyb" +
           "5db24eUFqbQ+9BzSkEcfIxUS1NhCfDIzu2IGGzBHDMiEUhLYcdyuCy/q2ybu" +
           "buv7s7X95+QQsMY1PRS9ffCN7S9z7q3EXLvJMdmTSSEnezi9HpsIRlket/Kt" +
           "J7qz8Z0d9733iLUevw/5BtPde775eeSOPRYhWpX/eVnFt1fGqv59q1ucbxYu" +
           "0f2XYzt/+tDOW61VNWbWsV1wTHvk9c9ejtzzhxdzlFIVI6oqU0FJB3YoHZiz" +
           "M+G2jLrytrqf3dlY0g2Jt4dUmop0nUl74pn+VmGYIx783VOF64O2eZh8GAm1" +
           "AytYuRXby7C5yvKqlblYybq1FJveTD6tcYpj59Pjex7aKeXX8xi5MKCQHB1n" +
           "kfVrBzdhRlQVwMEpIh3BFQGCxvhoBOQwja8xJSxk/ZIX5ZnSluyHIwPULFmi" +
           "F2SJjuhSfJRGrtbikK17BQWOcWkp9J3moLMa95sDN+/ZH9/4wIqwnfquYaTc" +
           "PkK7WDWimgyK7uVHU5fv3qq9690ft42uKaQExr6WaYpc/L4QHLo9ODz9S3n+" +
           "5g/mb1o1tq2AanahDyK/ykO9R15cu1S8K8zP4RYRZ53fM4U6MsOhSqfM1JXM" +
           "ADgv7bh1zulOth1X9pOwGxrZDAxbppkjsiT6WLg2j0Jf9eNEvO1lzTybCxMA" +
           "9zjuezoGuvArX8z1eeqnXdgwRs4RHblNOtALFtqdY5DVqPWjxoDNb/jxNUZK" +
           "x1Up7ka/mSf6z6ImwY41Gu/XMnG+DA21YTHy4IzNRDaiQaK5EcWvN3Ctt+cB" +
           "7NvY7GZYKdiA9VOsWuPYf5OLyW3FwmQlLHXKNmyqcEyCRPN7WeSsCdR1u3vz" +
           "oLgfm71QdQOPckGgHp1lgbivmCDuspHYVTiIQaLBjvV9rvVQHkgexuYAIw0O" +
           "JBjJMs0G5YFigYKsdott2S2FgxIkmt+zomefYF3X+mEeHH+CzaOMNIEGSxLU" +
           "BWF5olhYXg4m7rUB2Vs4lkGi+bFsP6uKw4Xx2TwwvojNSYhQk8sGAfh0MSP0" +
           "QRuFBwsHMEh0ugg9lQeS17H5pTdCsXyAE7QflF8VE5SDtmUHCwclSHQ6UP6Y" +
           "B5R3sfk9I7UOKN2ClI3IW8XkrEO2WYcKRyRINBiRJ7jWv+VB5GNs3mdklpeA" +
           "+nSqCTr1wfJBMWE5bNt2uHBYgkSng+VMHlg+w+YTHyy50/6nxYTlYdu2hwuH" +
           "JUh0GlhClcGwhKqwKfGnq9zEEiotJjBHbOuOFA5MkOh0wDTlAWYuNvWMNHqB" +
           "yUUuoYZiofIlWOxR27SjhaMSJBqMynPc8tY8qLRh0wx0m7SSec4ACrUUE5Fj" +
           "tlnHCkckSHQ6RKJ5EFmBTTscyBxETENDd/Fjcn4xMTluG3a8cEyCRKfDZGUe" +
           "TFZhc6nrJXBENZNZiFxWTEQetc16tHBEgkSnQ6QnDyJXYXOlN25UTctCpKuY" +
           "iJywzTpROCJBotMhMpgHkWuw+SojNVaBn5tI+osJyGO2VY8VDkiQ6HSAiHkA" +
           "weIstJWRaguQnKlm+P+BRwrcMPNlBz4SDnBLzupNCUMn87LevbLeFxKP7q+r" +
           "nLv/6jf4r7vpd3qqY6QyYcqy9ymT57pc02lC4rBXW8+c+A/8IZWROblXxEgZ" +
           "/8SFhxRrtA4c7B8N4/ind5zJSJU7jpFy68I7BBAqgSF4Oak54CwM+qVzdVzQ" +
           "GNVT1jn4XC/6vJxsmm7T0iLeR/f46zV/Ec75pdm0XoUbFo/tX7/h+tNffMB6" +
           "dUCUhakp1DIzRiqsFxS4Uvy1enGgNkdX+bplZ2qPz1ji/Kif8eqCd23cdcCX" +
           "+TP++b4H6UZb+nn6mwdWPvXz3eWvhkloMwkJUG9vzn5GmdJMnTRvjmU/MhoU" +
           "dP6Ev2PZvZOrlif+/jv+FJhkPfv1jx8WTx3c8tpd8w60hMnMHlImQQZO8Yen" +
           "V04q/VQc14dIjWR0pbjHM0mQM55H1aKnCrz0RVxsOGvSvfhOCSOt2Y/jst/E" +
           "qZLVCaqvUU2FB29NjMx0e6yd8f3gb0ImyBRwe+ytxPZabCIp3A1wz+FYr6Y5" +
           "b2PMHNd4bG/JxTxbuEt/i1/i1e3/AwPPXlckKwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8dXqui7jRGXNsXlsiAERmItp3SYYJ+dQcTsW6m1Nq206AUV3mvait2pvdmgb" +
           "ETph05pvGD3rdatTbubJE5+oT3r1cKiH4Wrjt+QwcLb2vKppXp9g7a4xsc3p" +
           "ujmedOcxRdF12mU5Qo6XlmFmjM/nDrv0hsTWE3ohP4i9JaV4xg6l8tnGlYbk" +
           "irWlKj2YmesecAcJJuY8jU222Vwa8HrSdSZbasrsOrBHV2tzcV3vZuNVDYvE" +
           "2sywUbGp+guzP9g4BMd7vIlGPV9OQJVATfVKNtFaCuHI2CZFB1JnOadwZhvx" +
           "IbWA2UScyz09NMTNYhsSo+WiNaaiRkaNGyAruM26uklUtNbxQitbrxmtlpCN" +
           "+rrdYCY7eIq163ASShwn1ZChzVW2uDVk6xXGXk2doSmsSVjy+tS43m42vUoF" +
           "U/JKUwZTA5tq6dqvj1CsF+F4s1tjCEKsOVpsqKqi7jq+2AsSN6eqQ27JKD1O" +
           "IX2RgqO80tnhcA1Oh6hJ0FnSFJSsSq8Q1o6YqjPMvDjPttPUrrrrSnUtoJ1R" +
           "1R1xrM6OeZFRK/4qGBqtoKYuVnkYM3XYoKjYWVZ6qIPRA2BEDjHbYjzyGZ12" +
           "lprcARE2RCd9NRes6nrkELK/iRRRxZRWa9JOZlgnJvkqO7dHxLY+qq+jeldS" +
           "dSZqKNgkqo3nm0lvXBE3VYHzkkTox61Wez2c1il55ihCkAuZsevv1DG6lS19" +
           "uomT7rzF2lp3YaK+Op3tetEwqW3ibsQnSKu9bCas0Ruxsjqc9CJ1nWVzKsFY" +
           "nBonZH+QRohLIQvNUDduK/TV3a5KgVlntxx1kwg1OUvoKxO1w9cxqgPeM1Nt" +
           "m4hmgGXaesXovO+C1wdl1Am1CdmUcGnViDA18OeDCtmg4JUR9xBeqc1aaLua" +
           "T6tOP7ZtZr0B/JO2I9M9uIX6K3i202WVna6qVms1H9Qr8dqBa7o+q80yR0XX" +
           "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" +
           "cv06LZiNejehKv4yl5c5M5gu54jh1NdduLkbpaFtY/OqPlFYWK038yVMSFjD" +
           "k+3q2l2IfReO1hisVaKpqlJ4U150F5pgegiYt1jdD/spV1/sMkRxBtupKa8r" +
           "omdtUH+WI4YOj3W1pfhdGa1JstRdV+azSkWsD5uLjVhxnKadyKvZbp3XlNVO" +
           "My2XAjX+YtDe5U5jYMsjypmzO8NewJTmLuRZk9ihs81uQweWrlZgY1fpjzRz" +
           "pu4QIwX1QFoDvuXJraRZ1SgH+DdpM8yGbvGKs6zWfXjJSEhdJo0VW/VEY0hV" +
           "bYZqNIaIMHa6QV5ll2lID3bcTtXoLkdHKA8bYQQT/may7Ar+brFA+zjanhpU" +
           "WlWamdxSa1uxStoZGG2lkkXpbCOIXdKrdZAkr/T5oMk3RHRGDadyXRzAo3Se" +
           "ijERwToCfpUa3Elms7UlmeOk0ymWRLbf31LNg+Wq1JXNXMPCiger72M1Jr3B" +
           "amRx2Uuv3jm5/3gr8Pj/qdXNq1aXj9bEqjfYNtvuosPRYDkvltNcR3Gi4y2z" +
           "Y0HkBoLhbnsI5IotFDzWi227s5LoOV0eSbKKAwSvFf2Ra0TFQJe3yuHCk4VI" +
           "ocC0vD2RKhY9n7jRznS54Pnpj7z4skz/GnLhaOdhHEF3Hh0YOLHVQ6CZZ2+8" +
           "skuVu/Iny+Ff+8h/e3z+o9oHvo8Nv6fOKHm2yc9Sr/z+4Iekn78A3XZlcfya" +
           "8wJXCz139ZL4vYESxYEzv2ph/IkrrnPxeDfZOnId6/qbbjf2w/fu3f3Mrs7B" +
           "0bbp0fA9US6HCgmw4g641OEV5yKKj2ULP3POvtDPFuTDEfSD0rHcPBCcsNhi" +
           "7GqCs1Xk66597lxdPgm0j7zRsufpXssbP321mVoFoCMzhTfVTMXHj5UMv3SO" +
           "FX65ID8fFTstR1ZglWKLTS7u/50ToL/wVoG+D6iUHwHNb4k/HL7pHHLiIH//" +
           "HNN8piAvR9BFkEpKQS4Sgugay/y9m2GZDx5Z5oM33QU+XTJ86RycXynIK2Bq" +
           "OcZZBJKlXIv0828VaZETPnqE9KO3xAfgNz8bnDjBV88xzu8U5Lci6GHQwl4S" +
           "NHcjA/3jt2qgNoDy0pGBXrolBnr2Tc15J7b5+jm2+RcF+V0QIHEpeyOrfO1m" +
           "BMivH1nl129RgPzhOTj/fUG+eTpAijnRsq5B+q9uBtLPHCH9zC1C+l/OQfrH" +
           "Bfl2BD1wjLQv6NfC/I83Iw989gjmZ286zN8uGV4/B+b/KMifRdDbTwf1LFA8" +
           "IVDOYP3OzcD6uSOsn7tFWP/qHKzfK8hfnsF6/Znsf98MrL9xhPU3bg3Wg3tu" +
           "jPXgbQW5/Wyyvn6wHtxxM9C+coT2lVuE9uFz0D5akEsR9NBptNcL2IMH3yrU" +
           "vwGU+sIR1C/cdKjfKOE8fQ7UdxfkHSAv2fv56br+e/DEzYD56hHMV28RzB85" +
           "ByZckPeCYvwYZhx6xcCeBfqGhy3eDNAv");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("HgH94i0C2j4HaHEY5KB+Mp7gnSO2r4HZuBkwv3QE80u3CCZxDsxBQd5/2m1d" +
           "z7sG5hseanozML98BPPLtwgmcw5MriCTCLp/XwdePzipm4HyK0cov3KLUP7E" +
           "OSifL8g6gu7bo7xuouW/H5ApcIyrD5CXLKBIf8+bOn0eBtBj13yfZf8dDOkL" +
           "L1+8+9GXF/+mPHB95XsS90ygu9XYsk6fbjx1facXKKpeWuqe/VlHr0SuRdAj" +
           "19cogu4o/xeKH2z33CbIX2e5AV/5/zSfE0H3nvBF0J37i9MsfgTdBliKy8A7" +
           "Ns5TN1r26ciCFylBun/Xeey0K5XlzUNvNDhXRE4fzi5W6MovFx2vpsX7rxc9" +
           "L7368mj6U683f21/OFyyhDwvWrl7At21P6deNlqsyD19w9aO27pz+Mx3H/ji" +
           "Pe85Xjp8YK/wiVuf0u2p65++JmwvKs9L57/16D9832de/qPyVOD/B6uyL5r1" +
           "NQAA");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1KeKwPixDUZirAI7gtFvadQ/ChjFgd2X1KOw801vgNeqSMqq4OO3OFjZACCv" +
       "x0pjpNYQBZnaVzsOk9rz/0AxB2vlzu/xXevUou/lzG+8xIePNVRPObb1LL9/" +
       "KXyHNT5GqpNZWXa+DXQ8V2o6TUoc//Hmu0F+SxsCjJpHzpQBPP6LUoduMUfv" +
       "h2joHQ3j+K9z3EFGauxxjFSaD84ht0NIgSH4eIjjsC1nruYMJ1o8F588GsiO" +
       "S7D5rssj/mVi/qIna36b2CeePrZ+497zK0+YX22IsjA8jFxqY6TK/ICEM8XL" +
       "onm+3PK8Ktct+qL+kXEL8tdqE0yBbTufYRsUaQfb03Btp3s+aTBaC182vHH8" +
       "8qdeOlD5SpiEtpOQwMjE7cUvinNaVieztseKL/V7BJ1/a9G26IdDV16Y/Oub" +
       "/FU8MV8CzPQf3ye+dnLHq3dOPT47TGo7SYWkJGiOv8FeM6SA+xjQe0mdZHTk" +
       "+EmJSYLsemNQj2Yo4DeLHBcLzrpCK37zw0hL8QuT4i+lamR1EF+qZZUEsqmL" +
       "kVq7xVwZz31bVtM8BHaLtZRY32a6BlwNsL2+2AZNy79Pqt2rcRs86J/h3M8f" +
       "8elH/wORrKZstSwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/82zpbsOjmyvudR2vNGLxw9qL/hqGPn2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7Nhx7ZMHkn0kl9hPgPTqnmRfPfnu+XDurv/i+b27uT/lrsHXT6n7Rp79i7D0" +
       "xEoN2eufOxVvrw+V5zff6vXo0SGKgt84fi0GBem1PbSv3Rm0Zw4JooLg354C" +
       "+Vt59q8B5OCGkK/7qjh2dOVQDN+8DTHkF4NKMEhf2hPDl25VDO2bE8MfnCKG" +
       "/5Rn3w5Lj8m+KobqwVnysWOgQ7zfuQ28T+aF+QHLG3t437gzeI/C+cEpdf89" +
       "z74Xlt5+FOrJs7v6TZ7dXdu4kM8f3YZ83psX/iWQvrInn6/cefn82Y3rzhRD" +
       "/e+wdGknn5EjKjcrnSBeXQECAiFhZKl2mDdV/Wul86e3IZ1H88KnQfrqnnS+" +
       "emecxlEJPHBKXX6Z6sx5sEQBF0keXms5AHfm3tv1iI+B9K09cN+68+AeP6Xu" +
       "iTx7JCzd46vAHeYUv3cI7O23Aaw4VH0PSN/dA/bdO67TZy6fUveePHsaREQH" +
       "Xn5y5LLkEZDP3C7I5wG/X9u13f3eWZDwKXXVPCuHpYtg9vTs0IcHJzC+/zYw" +
       "Pp4XAud95o/3MP7xncF4d0Fw9/WW2rv04jbOmQ8eZgXcD5wiCjzP0LD0zshV" +
       "Dnw8WNiLFV039TDdd2WHV39aOvBZwX6EWEgKu11t6JdKZyu7trvf25fU2YLg" +
       "bP5vcYugWNvPUKcIg86zHljwTggj/45EPaEb/dtFXAa8tfcQt++8/i9PqftQ" +
       "ns3C0qNgWZI3uK2wasjvLozkN0NOIH3La3GnIH0iLwTr9Fl6Dyl955Gqp9Tl" +
       "lxTOvBSWHlxdg/BvHCIUb3clyhFu9hBubhXhqbH59ez8Hs10xLDA552CPc4z" +
       "sPG6P5BFUz28UnNkaq1bAZ4AMR6P6vLr4I9f81HW7kMi+Vdff+jex17nvlV8" +
       "RHDwsc99o9K9WmSaR+/kHnk+5/qqphcCuW93Q9ctsLwMlPX6oRQQR/Gbs3vm" +
       "YzvqjwPXfpIa0BW/R+n+ali6cEgXls7tHo6SfAq4VUCSP366mM9JspuTx4+q" +
       "QxGsXXorYR7Z6L/72Pa8+Pxtfysd7T6Auyp/+fXB+Kd/iHxp9zWDbIpZlvdy" +
       "76h0fvdhRdFpvh1/9oa97fd1rvfCjx78tfue33918OCO4UPVPMLb09f/dKBt" +
       "uWFx2T/76mNf+cAvvf77xZ2j/weRiqNElzgAAA==");
}
