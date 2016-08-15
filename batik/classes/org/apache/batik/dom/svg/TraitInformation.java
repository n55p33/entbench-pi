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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
