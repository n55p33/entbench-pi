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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0opsXXUzn+zFEBedweZ5p9rwhckLExUm87gI8ZMr3z9BrCF2vhEydhabV6DG" +
       "csKEJlebVMLela4zXp0AZ8zAsSXw3GdbdF/5zghiDTH4vZCx97E5BznJdcYa" +
       "PaslIZicQJuVD7QU1TOxLXDQgYOZSm0K7q13JsBbU3BsPjwHbJMPlO+tINbw" +
       "rTWt0OI+Hfxib67zIb78HJuPGWlQNE9cFV6lYiXanx2ymK/kuKpvpzze2feJ" +
       "qE9mlWAQdNNOxH+y7d1db/CSsgZr2Hwh56lfoda1K0psm7EZF26/1/N+PyPV" +
       "Q7quUkkr8oRJphbqIKa/+cdNvz3QWrEWiuteUpPVlDuytDdZWGBWW9khj1Lu" +
       "5xTe4dUISyJGIkud+xAeSp9MFArhIfmoHQ9Hyw+lINbggIhEQsYqsPMbRpqx" +
       "gKGaxWOhBA59O1E4hDX+CdumE+W7I4g1xOTGkDGMiEgtI1O97nCQCBk+yLsk" +
       "UjdRYIOn4mdtu54t3yVBrMGl3afc9jkhfmnDZjrj33n9UfKl65IZE1nanLHt" +
       "OlO+S4JYg12ykpt9eYhL8O4tslBUu/lLKbeMiXROZLV71jbobPm+CGINMTXk" +
       "+j1yLTZXimrXvZtz3bDi/+GGHFQGxV8T8b57ZtG/KYhP6/JTx5pqZhy79V1+" +
       "/5L//F0P2Wo4q6reG1nPe5Vh0mFx0KkX97MGN/JGQIRS11CMVECLWkdWCco1" +
       "AKV+Sqhz+W8vXQ8jdS4dI1XixUuyDqQDCb72Gk5N0MxrArySjokr6ZxA9zle" +
       "D3LEnnYpx+dZvJ+t8AKD/4OIk3Oz4l9EBuVTx9ZvuvPCysfEZzNZlfbsQSmT" +
       "IdOKL3h2qvfeH/ilObKq1i35uvHp2kXO/UGLUNgN3jmeeqYbtqSBaz3b903J" +
       "6sx/Wnrv+PUv/WG86q0oiWwnEQmOJduLL+9zRtYkbdsTxRXFNsnkH7u6lhzd" +
       "vWr58D/e559HiKhA5gbTD8rnHr/t7YMzj7dHyeReMknRkjTHvyrcvFuDCnXU" +
       "HIAyzOrJgYogRZHUgnKlEcNSwn8d4X6x3dmQ78WProx0FF/5FH+qrlP1MWry" +
       "TIVioOCZ7PaIlfHdv2UNw8fg9niqtq+wGednHojHwcRGw3CukCq/Nfj+vFgK" +
       "QC/yGN7BX/Httv8Bgh1UJjwmAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vtsy3r97LhQUYN4PHO9We7YYugfkObvn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3rej/AAIQ6cpwWqj+HuSjoihy3u6GLq4+zhJAjat9wCS/JMKjqaGEy8mdi+k" +
       "st2s8dhJKygi+rXvJ+DjJiffNeYbxOI5/tFmLtk9yH9J+eLrzOBD36n//O5d" +
       "peJI223ey30sdGn3xLPoNN8QPnvb3o76uth9/rsP/cr97zravD60Y3hvkSd4" +
       "e/rWjxg7bhAXzw63//jRL73vF17/w+LJyP8Hnjpq0icxAAA=");
}
