package org.apache.batik.bridge;
public class RepaintManager {
    static final int COPY_OVERHEAD = 10000;
    static final int COPY_LINE_OVERHEAD = 10;
    protected org.apache.batik.gvt.renderer.ImageRenderer renderer;
    public RepaintManager(org.apache.batik.gvt.renderer.ImageRenderer r) {
        super(
          );
        renderer =
          r;
    }
    public java.util.Collection updateRendering(java.util.Collection areas)
          throws java.lang.InterruptedException { renderer.flush(areas);
                                                  java.util.List rects = new java.util.ArrayList(
                                                    areas.
                                                      size(
                                                        ));
                                                  java.awt.geom.AffineTransform at =
                                                    renderer.
                                                    getTransform(
                                                      );
                                                  java.util.Iterator i =
                                                    areas.
                                                    iterator(
                                                      );
                                                  while (i.
                                                           hasNext(
                                                             )) {
                                                      java.awt.Shape s =
                                                        (java.awt.Shape)
                                                          i.
                                                          next(
                                                            );
                                                      s =
                                                        at.
                                                          createTransformedShape(
                                                            s);
                                                      java.awt.geom.Rectangle2D r2d =
                                                        s.
                                                        getBounds2D(
                                                          );
                                                      int x0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getX(
                                                                ));
                                                      int y0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getY(
                                                                ));
                                                      int x1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getX(
                                                                ) +
                                                              r2d.
                                                              getWidth(
                                                                ));
                                                      int y1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getY(
                                                                ) +
                                                              r2d.
                                                              getHeight(
                                                                ));
                                                      java.awt.Rectangle r =
                                                        new java.awt.Rectangle(
                                                        x0 -
                                                          1,
                                                        y0 -
                                                          1,
                                                        x1 -
                                                          x0 +
                                                          3,
                                                        y1 -
                                                          y0 +
                                                          3);
                                                      rects.
                                                        add(
                                                          r);
                                                  }
                                                  org.apache.batik.ext.awt.geom.RectListManager devRLM =
                                                    null;
                                                  try {
                                                      devRLM =
                                                        new org.apache.batik.ext.awt.geom.RectListManager(
                                                          rects);
                                                      devRLM.
                                                        mergeRects(
                                                          COPY_OVERHEAD,
                                                          COPY_LINE_OVERHEAD);
                                                  }
                                                  catch (java.lang.Exception e) {
                                                      e.
                                                        printStackTrace(
                                                          );
                                                  }
                                                  renderer.
                                                    repaint(
                                                      devRLM);
                                                  return devRLM;
    }
    public void setupRenderer(java.awt.geom.AffineTransform u2d,
                              boolean dbr,
                              java.awt.Shape aoi,
                              int width,
                              int height) {
        renderer.
          setTransform(
            u2d);
        renderer.
          setDoubleBuffered(
            dbr);
        renderer.
          updateOffScreen(
            width,
            height);
        renderer.
          clearOffScreen(
            );
    }
    public java.awt.image.BufferedImage getOffScreen() {
        return renderer.
          getOffScreen(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iyM0tu/zLjYf/Aeff1tobR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xqf4xNTJ7bY338K2PYdziV+lfnM115tIvdaOU0FQjfpeWI57+mLdxmCfHk8L" +
       "ciONUkHLlR6Nz2EFL3bpcNOfjeKOZDbDzcZzeytO8wco30uXvJTURwXbmRiS" +
       "yA+klTmJm0NPM22Gi7l0vJD4DYenOUunFo5kndBckVwu1+HxvIbpUqjNRKvP" +
       "bmGK2jK8VNP4BQtCeTH0g00tlEh6MEp5ZznKfY2crRdOo1jjibacrYuR6OkE" +
       "6s1DBewbu852LbQKqj2wNjU8YLCh01pgujB3847F5wuZG9kO6nfjrGMPZLcI" +
       "xGTYCXspYrmJgpPEtkjkWiubZFsdhFTLWV7vTQuz3dtQc3lba0xGIc31YncT" +
       "NrZ2Z75oJaSt7lxzKdPdwcYNzVq0DQxkCQdDy8BaTKe16w5wM6aRET+JMqYw" +
       "g5W6NVZGarI+08l2nCGiVHMxlRZqzdtsdVORrVq4JBtKbUkMPE5s7DbyAmY7" +
       "dD/wawbjm25rwtQ1lxmKTD0IEQP2xjzNrWsWFdXAp1LWFeWxTFid+rJXU1Mf" +
       "I8YLZdvi/ZrgLWYIthhGWEhjnDnqDZGm4BL8LA5YzJrmHR3zkc7eFDKa6iSx" +
       "EyV1ltZktw9zaKvTTv1BLeQ0hm4u+qjemS8RpBjPx2LPGHZb8cYMVKYXZQT4" +
       "cm23VxKh751IMNsgUojm01UbTlrmnphYmVRz5B2/jrnVHDW1Fjuxld1gIa/Q" +
       "Wne72yHs2DM7qpA2eZQ3MylYFkWRSbSoCE7THDPFyClMwa8HI3fhTTxqPBZ9" +
       "AXwVMWJLDyaeaPJzEHhLvRpwqYN8Ls4Wi2K2CDB62O8q+HKzQ9F0wbSVvuSq" +
       "KmlETG6oSR8VjTBdtATF3Rgx0L8msD0kWXoyY8t5DnZuSmuPlgtxQjIGkdhr" +
       "YST7fQpvMMuIB99aQ2fP15IUKbj1ykS6hmmiSaBOcfDx/9GPlscCn3h7xxWP" +
       "V8cvp5nptdcqO7y3cSJx6HquLJ4/PayqftehS9nM87mRs8NvqDwnfOZeCefq" +
       "jPC1T7/yqj7+afTqcdJgmkAPJUH4A56RGd45VPcBTC/e+zyUr/LtZ4fZv/bp" +
       "//707GP2x99GWu/9l+i8jPLv869/rf9h7cevQvedHm3fcRPg4qCXLh5oPxwZ" +
       "SRr5swvH2s+cSvbJk2PAjx1L9mOXjwHP1u7OM8BKCw5rfyknc+U0OfrcPQQ4" +
       "VfJqVW5rvzz51je+XHzl9cOJrKrERgLB97pRcuelljJ7+fybZGDP7hr8fv/P" +
       "vfG7/2XxQyfr/o5TMXz45AT0nmI4OUB8190yaGXfFyuUf+secjge/ezF9EAU" +
       "pWFi6NROM8IST4Xi75bFX0+gG2moK8lx6svxDwehP34xKfrut1q5L1bFmen9" +
       "jbc6DDyfU6oa/urFGUvL2xzP6Pzp6Mq1CuDaiYyeqWSk5MmRZQSbo65pOr4x" +
       "ixQ/LhPHdzv1fEANAs9Q/BMMj51iEG3loPfVSblQTf+zb5I+/Adl8VMJ9CjQ" +
       "wTQ8yTre9aQ1Cxz9TK6v/Qnk+t4TG9wdy3X3pyPX84z96pv0vVEWv5xAj1hG" +
       "MjZNUYsM41SW7zuVpVMmYo+I1Cxz+3qVlj3j/5++Hf53YIkuXrooM8jvueMq" +
       "1+H6kfYLr9548KlX5/++undwekXoIQ560Ew973zy7lz9ehgZplPx99AhlRdW" +
       "f19LoKfucREkga4fKhXBXz3Afz2Bbl6GT6Br1f95uH+TQA+fwQFUh8p5kN9I" +
       "oPsASFn9t+FdEhKHHObuysXN7FTET7yViM/tfx+64A+rq3QnO0wqHLvdr7w6" +
       "GH3iu82fPlyL0DylKEosD3LQA4cbGqe71HP3xHaC6zrzwvce+8WHnj/xrI8d" +
       "CD7T23O0vf/udxCoTZhUtwaKf/LUP/rIz7z6W1Um9P8BrKfEe+MoAAA=");
}
