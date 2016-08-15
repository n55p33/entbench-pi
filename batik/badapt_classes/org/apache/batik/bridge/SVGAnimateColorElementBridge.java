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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xeX/AoXGfyFLGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3mGG4XKp2S2lSqPDRkBo/oBFMNzsaT2xXp+VmbYM9CtaltjZpGOiCruUuuH6" +
       "rlDlhtKEZeK1Egr1ZGMnND/3ecns9+LNtBrKZqvAL4JIU8c8VhYqZXrk1yKT" +
       "mQyRmUSvJMSLuotUdokyQybDEl3r9bhojvNkyxdXg9K8oZIFq1uFV2apVitq" +
       "UdNRhiMa69GLotBodNrLYr/c5+NuY86WRlaZRsyaMcKKPuIPk9UKUQuOhMgF" +
       "KRa7iNiOpBqwq9UO/XUXrnRXDazpNsiSvy4IKsmvV9XueES7PV/y9A29nBNL" +
       "Jk1ZvmbjLZQqFcLusB2IBNXjrT5IBHAtUhhuaEuV1EgXkie4VDtwUIXCpvVp" +
       "w22GVGGlNKoMi05khOS5OYa6XSas2zO5tLbUuIKXF6GMNirMojTx7bjCWl4C" +
       "p4PBnORIvNAlZklopA2rw62pQZHXmHrcr4GpPEBGCkgppMpsQ4xn7VgtdzTH" +
       "p6zKpIzzA78a0TrGWmtjPSkool9ZSKtAl0uGwgWmK7gtGeywPT+U2yu5IiwW" +
       "2tKbNWsEMiVEGIOttSWwBsUmYzwqj4QamZgVbt1JsYE35QYOvJp1Yc83aWtO" +
       "62k3mlXaG5CntPQglQYLxLb4RkEt9Np9vextZLFCi6Is9JC6vwpFUl6tC8U+" +
       "gTuUlprhypnGdUVZTQkrVnGC8/i6OkKIKqsYOCahzXhR7fsTd2OZnFLyV5GD" +
       "sDEq6BW0vigZKzFKxYQmK8pMXpQ7LU8ez2grBttxsQTWFNtf17GggOJd1vM6" +
       "hU2xFCk9H19WbXqqYbVuncfTyrKmrpFig2lshpM2gfZgOEXgVrTEY3GNqJ11" +
       "ob5KzNXGT+VmhU5Vtu23+l2rMCXZHmow04lVm8zWetsmCJ0PqKTuJ4bW5xw0" +
       "LIbjeqfGsMvC0Ega1twn+Fk/nUSUW2ZSTp5IpC/16DnNCJIlTquxXIzqnYZT" +
       "VH2TIlhB09CVic3tjWarC8HFaqlPt/WYlKadaTyA9SJjLuGqSK1xp2Glygxu" +
       "ujNCXXcoQms2sy3bO17drvmO/IDg4F4HbJazBuJV7Ba3TQ9nxWMHh6L55+wN" +
       "DkWPHBxB2Q74/utd1+S73+ff98xzMv1xdGfvwI2PoFsi1/sJS1kp1hFW2dXk" +
       "m6+/0x/kt1WHB0FfeN+/3jt9m/6uV3HU/eAJOU+y/K3BC18i3iD96g50+uBY" +
       "6Kp7tOOdLh8/DDofKFEcONNjR0L3H1j2zsxiD4DnTXuWfdO1j5uvGQWn8ijY" +
       "+v4G55nBDdryE1o7gm7VFBDTkmAN90QnDsPFeaXDhaNM8wrzuH73gwfe0w/+" +
       "0ev3nhu05UdP6wh6DdBv30P7p2UPXO/KZns5c2iAzQ9hgIf2la7uGaD6agwA" +
       "JoYXuJEiRYp8TTuc2rsY2lPp8atUkl17V3AMe3d7CQWmw1QIgDFybr90A8v9" +
       "SlY8FUEXpEARIuWg+/5Qb7xqqO0wYhgFghQdp8/N+PQPYca7sspL4KH2zEi9" +
       "2jh6/yvab3wEG7kIOm04Wyt97AZW+o2seDaCbpcEZ++a7+Bq6QS/c6LrWopw" +
       "xCAf+VEYZLpnkOmP3iDAy2+5tpfz499wL6ay25v8OD1n+OINrPW7WfHJzFq6" +
       "Ii3zPvvA+PyhWX771ZgljaD7bnTFmt0R3XPVXzy2f0uQPv3chZvvfo79m/yW" +
       "8eCvA7dQ0M1qbFlHj/SPvJ/1AkU1cn1u2R7we/nXH0XQ3ddBlAg6Kx5iyh9u" +
       "6T8XQRdP0kfQmfz7KN1LEXT+kA6w2r4cJfk8iFZAkr3+mbfvOviVb6SPWSo9" +
       "dXwVP/DHna/kjyML/6PHluv8Hzj7S2u8/Q/OFenF53rDd79c/fj2jlSyhM0m" +
       "43IzBZ3bXtceLM8PX5fbPq+z5OPfv/0ztzy2n0rcvhX4MPaPyPbgtS8hcduL" +
       "8mvDzR/c/Xtv/c3nvp5fXfwf8qPvUholAAA=");
}
