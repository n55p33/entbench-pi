package org.apache.batik.gvt;
public class StrokeShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Shape strokedShape;
    protected java.awt.Stroke stroke;
    protected java.awt.Paint paint;
    public StrokeShapePainter(java.awt.Shape shape) { super();
                                                      if (shape == null) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            );
                                                      }
                                                      this.shape =
                                                        shape; }
    public void setStroke(java.awt.Stroke newStroke) { this.stroke =
                                                         newStroke;
                                                       this.strokedShape =
                                                         null; }
    public java.awt.Stroke getStroke() { return stroke; }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (stroke != null &&
                                                       paint !=
                                                       null) { g2d.
                                                                 setPaint(
                                                                   paint);
                                                               g2d.
                                                                 setStroke(
                                                                   stroke);
                                                               g2d.
                                                                 draw(
                                                                   shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null ||
                                                   stroke ==
                                                   null) return null;
                                             if (strokedShape == null)
                                                 strokedShape =
                                                   stroke.
                                                     createStrokedShape(
                                                       shape);
                                             return strokedShape;
    }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { java.awt.Shape painted =
                                                              getPaintedArea(
                                                                );
                                                            if (painted ==
                                                                  null)
                                                                return null;
                                                            return painted.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) {
        java.awt.Shape painted =
          getPaintedArea(
            );
        if (painted ==
              null)
            return false;
        return painted.
          contains(
            pt);
    }
    public java.awt.Shape getSensitiveArea() { if (stroke ==
                                                     null)
                                                   return null;
                                               if (strokedShape ==
                                                     null)
                                                   strokedShape =
                                                     stroke.
                                                       createStrokedShape(
                                                         shape);
                                               return strokedShape;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return null;
        return sensitive.
          getBounds2D(
            );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        return sensitive.
          contains(
            pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape ==
                                                       null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.
                                                   shape =
                                                   shape;
                                                 this.
                                                   strokedShape =
                                                   null;
    }
    public java.awt.Shape getShape() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lCJbV93MJ3sxxEVnsHneqTZ8YfLCZIXJPC5C/GRL908Qa4idb4SMncXmFaix" +
       "nDChydUmlbB3peuMVyfBGTNwbAk899kW3Ve6M4JYQwx+L2TsfWzOQU5ynbFG" +
       "z2hJCCYn0GblAm2E6unYFjjowMFMpTYF99Y7k+CtqTg2H54DtskHSvdWEGv4" +
       "1mrNt7hPB7/Ym+t8iC8/x+ZjRuoVzRNX+VepWIn2Z4Ys5is5rurbKU909n0i" +
       "6pNZRRgEXeuJ+E+2vbvrDV5SVmMNmyvkPPUr1Lp2RYltEzYTwu33et7vZ6Rq" +
       "SNdVKmkFnjDJtHwdxPQ3/7jxtwdaytZCcd1LqjOackeG9ibzC8wqKzPkUcr9" +
       "nMI7vBphScRIZKlzH8JD6ZPJQiE8JB+14+Fo6aEUxBocEJFIyFgZdn7DSBMW" +
       "MFSzeCwUwaFvJwuHsMY/Ydt0onR3BLGGmNwQMoYREalhZJrXHQ4SIcMHOZdE" +
       "aicLbPBU/Kxt17OluySINbi0+5TbPifEL23YTGf8O68/Sr50XTJjMkubM7Zd" +
       "Z0p3SRBrsEtWcrMvD3EJ3r1FFopqN3cp5ZYxkc7JrHbP2gadLd0XQawhpoZc" +
       "v0euxeZKUe26d3OuG1b8P9yQhcqg8Gsi3nfPLPg3BfFpXX7qWGP1jGO3vsvv" +
       "X3Kfv+sgWw1nVNV7I+t5rzRMOiwOOnXiftbgRt4IiFDsGoqRMmhR68gqQbkG" +
       "oNRPCXUu/+2l62Gk1qVjpFK8eEnWgXQgwddew6kJmnhNgFfSMXElnRXoPsfr" +
       "QY7YrZdyfI7F+9kKLzD4P4g4OTcj/kVkUD51bP2mOy+sfEx8NpNVac8elDIF" +
       "Mq34gmeneu/9gV+aI6ty3ZKvG56uWeTcHzQLhd3gneOpZ7phSxq41rN935Ss" +
       "ztynpfeOX//SHyYq34qSyHYSkeBYsr3w8j5rZEzStj1RWFFsk0z+satrydHd" +
       "q5YP/+N9/nmEiApkbjD9oHzu8dvePjjzeHuUTOklFYqWpFn+VeHm3RpUqGPm" +
       "AJRhVk8WVAQpiqTmlSsNGJYS/usI94vtzvpcL350ZaSj8Mqn8FN1raqPU5Nn" +
       "KhQDBc8Ut0esjO/+LWMYPga3x1O1fYXNBD/zQDwOJjYahnOFVNFq8P15sRiA" +
       "XuQxvIO/4ttt/wMjAMTEPCYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KCjBfAA43vX2bDF0B8gLds+9f0/5QRCG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zlKC1Ub59zRdN4buO9DF0IX9x2kSsGm9A5AUn2RwPDWcejGxfyGV72eNx05b" +
       "QRnRH/5hAj5pcvpdY7FBLJ/jH2/mkv2D/JeVL70xmHz4e/Vf3L+rVBxptyt6" +
       "uWcE3b1/4ll2WmwIn71hb8d9XaBe+P6Dv3bv88eb1wf3DB8s8hRvT1//EWPf" +
       "DeLy2eHu7z/65ff/0hu/Xz4Z+f8M+5P9JzEAAA==");
}
