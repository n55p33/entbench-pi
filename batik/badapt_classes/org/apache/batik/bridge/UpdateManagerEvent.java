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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8+jRlYgQQveGrvdtQL2adYrUJUDpmdsfsHLlBw4np5x/+L6/f3T6HZv3voa7" +
       "07ec4/M8yV/mXv58/5uVH78IXTo+87zp04uznZ49e9J51ddA3OlMz5x3Pnas" +
       "2TcVGnsSPLNDzc5uddp3/Q6HcN+6n/s7HHj/wh3qfqlIfjaE7llrIX18Snpi" +
       "Kj/3Wg7Hy4KXjmUrmxUXL+8+lO3d//GyffoOdb9aJB8PodcD2cjbHbeWt0PX" +
       "Xo3JwyuZY7V84t+hljcUhW8Hj3o4ovofr5ZX7lD3u0Xy2RB6E1ALcftz2xNh" +
       "f/M1XZCE0IM3fzlRXAM/ctO3WfvviZRPvHTtnodfmv1l+fHA8Tc/97LQPXpk" +
       "WadvDU7lr3i+phulQPfu7xC88t/nQ+jh23zREUJX9pmS6c/t238hhK6fbx9C" +
       "l8v/p9v9SQhdPWkHSO0zp5v8aQhdAk2K7J95R2fMbzy56Sw1sb9BSS+cRcxj" +
       "XT/4aro+BbJvPQON5QdyRzAW8YfX3J98aTD8nq81fn7/gYNiyXleULmHhe7e" +
       "f2txDIVP3pbaEa0r1Nu+fv+n7n36CLbv3zN8Yq2neHvLrb8m6NpeWN7/57/+" +
       "8K++8xdf+pvy3Pv/Ay6e6R+5KAAA");
}
