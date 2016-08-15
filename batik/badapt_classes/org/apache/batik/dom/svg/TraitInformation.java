package org.apache.batik.dom.svg;
public class TraitInformation {
    public static final short PERCENTAGE_FONT_SIZE = org.apache.batik.dom.anim.AnimationTarget.
                                                       PERCENTAGE_FONT_SIZE;
    public static final short PERCENTAGE_VIEWPORT_WIDTH = org.apache.batik.dom.anim.AnimationTarget.
                                                            PERCENTAGE_VIEWPORT_WIDTH;
    public static final short PERCENTAGE_VIEWPORT_HEIGHT =
      org.apache.batik.dom.anim.AnimationTarget.
        PERCENTAGE_VIEWPORT_HEIGHT;
    public static final short PERCENTAGE_VIEWPORT_SIZE = org.apache.batik.dom.anim.AnimationTarget.
                                                           PERCENTAGE_VIEWPORT_SIZE;
    protected boolean isAnimatable;
    protected int type;
    protected short percentageInterpretation;
    public TraitInformation(boolean isAnimatable,
                            int type,
                            short percentageInterpretation) {
        super(
          );
        this.
          isAnimatable =
          isAnimatable;
        this.
          type =
          type;
        this.
          percentageInterpretation =
          percentageInterpretation;
    }
    public TraitInformation(boolean isAnimatable,
                            int type) { super();
                                        this.isAnimatable =
                                          isAnimatable;
                                        this.type =
                                          type;
                                        this.percentageInterpretation =
                                          -1; }
    public boolean isAnimatable() { return isAnimatable;
    }
    public int getType() { return type; }
    public short getPercentageInterpretation() { return percentageInterpretation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
