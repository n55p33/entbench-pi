package org.apache.batik.bridge;
public class SVGAnimateColorElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_COLOR_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateColorElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatableValue from =
          parseAnimatableValue(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseAnimatableValue(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseAnimatableValue(
            SVG_BY_ATTRIBUTE);
        return new org.apache.batik.anim.ColorAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            ),
          from,
          to,
          by);
    }
    protected boolean canAnimateType(int type) { return type ==
                                                   org.apache.batik.util.SVGTypes.
                                                     TYPE_COLOR ||
                                                   type ==
                                                   org.apache.batik.util.SVGTypes.
                                                     TYPE_PAINT;
    }
    protected boolean checkValueType(org.apache.batik.anim.values.AnimatableValue v) {
        if (v instanceof org.apache.batik.anim.values.AnimatablePaintValue) {
            return ((org.apache.batik.anim.values.AnimatablePaintValue)
                      v).
              getPaintType(
                ) ==
              org.apache.batik.anim.values.AnimatablePaintValue.
                PAINT_COLOR;
        }
        return v instanceof org.apache.batik.anim.values.AnimatableColorValue;
    }
    public SVGAnimateColorElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xeX/AvlKnjtLGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bceP8mvD9A/u/r23/eazX8+vLv4P1rtSBholAAA=");
}
