package org.apache.batik.bridge;
public class UpdateManagerEvent extends java.util.EventObject {
    protected java.awt.image.BufferedImage image;
    protected java.util.List dirtyAreas;
    protected boolean clearPaintingTransform;
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das) { super(source);
                                                    this.image = bi;
                                                    this.dirtyAreas =
                                                      das;
                                                    this.clearPaintingTransform =
                                                      false;
    }
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das,
                              boolean cpt) { super(
                                               source);
                                             this.
                                               image =
                                               bi;
                                             this.
                                               dirtyAreas =
                                               das;
                                             this.
                                               clearPaintingTransform =
                                               cpt;
    }
    public java.awt.image.BufferedImage getImage() {
        return image;
    }
    public java.util.List getDirtyAreas() { return dirtyAreas;
    }
    public boolean getClearPaintingTransform() { return clearPaintingTransform;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "23/8xb8oz73/BxmCunC5KAAA");
}
