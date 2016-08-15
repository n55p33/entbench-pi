package org.apache.batik.anim.values;
public class AnimatableRectValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected AnimatableRectValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableRectValue(org.apache.batik.dom.anim.AnimationTarget target,
                               float x,
                               float y,
                               float w,
                               float h) { super(target);
                                          this.x = x;
                                          this.y = y;
                                          this.width = w;
                                          this.height = h; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableRectValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableRectValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableRectValue)
                result;
        }
        float newX =
          x;
        float newY =
          y;
        float newWidth =
          width;
        float newHeight =
          height;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableRectValue toValue =
              (org.apache.batik.anim.values.AnimatableRectValue)
                to;
            newX +=
              interpolation *
                (toValue.
                   x -
                   x);
            newY +=
              interpolation *
                (toValue.
                   y -
                   y);
            newWidth +=
              interpolation *
                (toValue.
                   width -
                   width);
            newHeight +=
              interpolation *
                (toValue.
                   height -
                   height);
        }
        if (accumulation !=
              null &&
              multiplier !=
              0) {
            org.apache.batik.anim.values.AnimatableRectValue accValue =
              (org.apache.batik.anim.values.AnimatableRectValue)
                accumulation;
            newX +=
              multiplier *
                accValue.
                  x;
            newY +=
              multiplier *
                accValue.
                  y;
            newWidth +=
              multiplier *
                accValue.
                  width;
            newHeight +=
              multiplier *
                accValue.
                  height;
        }
        if (res.
              x !=
              newX ||
              res.
                y !=
              newY ||
              res.
                width !=
              newWidth ||
              res.
                height !=
              newHeight) {
            res.
              x =
              newX;
            res.
              y =
              newY;
            res.
              width =
              newWidth;
            res.
              height =
              newHeight;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getWidth() { return width;
    }
    public float getHeight() { return height;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableRectValue(
          target,
          0.0F,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            x);
        sb.
          append(
            ',');
        sb.
          append(
            y);
        sb.
          append(
            ',');
        sb.
          append(
            width);
        sb.
          append(
            ',');
        sb.
          append(
            height);
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZbWwcxXXu/O3Y8Udi59tJHBOUD+4IJVTUhJIYhzhcEjdO" +
       "0nIpcfb25nwb7+1udufss2kKiVThVgKFNCRpBcmf8NEoEESLKGqhqWj5EKES" +
       "Hy2FioDaSqUFVNKqlJZS+t7M7u3e3t2mrnAt7Xhv5r037715n7On3ydVlkk6" +
       "qMYibMygVqRXY/2SadFkjypZ1jaYG5SPVkh/3fXO5qvDpDpOpqcla5MsWXS9" +
       "QtWkFScLFM1ikiZTazOlScToN6lFzRGJKboWJ22K1ZcxVEVW2CY9SRFgh2TG" +
       "SIvEmKkksoz22QQYWRADTqKck+ha/3J3jDTIujHmgs/2gPd4VhAy4+5lMdIc" +
       "2yONSNEsU9RoTLFYd84kKwxdHRtSdRahORbZo662VbAxtrpIBZ2PNH348cF0" +
       "M1fBDEnTdMbFs7ZSS1dHaDJGmtzZXpVmrL3k66QiRqZ5gBnpijmbRmHTKGzq" +
       "SOtCAfeNVMtmenQuDnMoVRsyMsTI4kIihmRKGZtMP+cZKNQyW3aODNIuyksr" +
       "pCwS8e4V0cNHdzU/WkGa4qRJ0QaQHRmYYLBJHBRKMwlqWmuTSZqMkxYNDnuA" +
       "moqkKuP2SbdaypAmsSwcv6MWnMwa1OR7urqCcwTZzKzMdDMvXooblP2rKqVK" +
       "QyBruyurkHA9zoOA9QowZqYksDsbpXJY0ZKMLPRj5GXsuhEAALUmQ1laz29V" +
       "qUkwQVqFiaiSNhQdANPThgC0SgcDNBmZW5Yo6tqQ5GFpiA6iRfrg+sUSQNVx" +
       "RSAKI21+ME4JTmmu75Q85/P+5mvuvEXboIVJCHhOUllF/qcBUocPaStNUZOC" +
       "HwjEhuWxI1L7kxNhQgC4zQcsYB7/2oXrVnacfU7AzCsBsyWxh8psUD6ZmP7S" +
       "/J5lV1cgG7WGbil4+AWScy/rt1e6cwZEmPY8RVyMOItntz5z022n6LthUt9H" +
       "qmVdzWbAjlpkPWMoKjVvoBo1JUaTfaSOaskevt5HauA9pmhUzG5JpSzK+kil" +
       "yqeqdf4bVJQCEqiienhXtJTuvBsSS/P3nEEIqYGHNMCzgIg//p8ROZrWMzQq" +
       "yZKmaHq039RRfisKEScBuk1HE2D1w1FLz5pgglHdHIpKYAdpai8AWiY6IqlZ" +
       "7txKRmJSQqVbgcYOnIygsRn/n21yKO2M0VAIDmK+Pwyo4EEbdDVJzUH5cHZd" +
       "74WHB18QJoZuYeuJkcth54jYOcJ3juDOEbFzpMTOJBTiG85EDsSpw5kNg/dD" +
       "+G1YNnDzxt0TnRVgbsZoJSg8DKCdBWmoxw0RTlwflM+0No4vPr/q6TCpjJFW" +
       "SWZZScWsstYcgnglD9su3ZCABOXmiUWePIEJztRlmoQwVS5f2FRq9RFq4jwj" +
       "Mz0UnCyG/hotn0NK8k/OHhvdv+PWy8MkXJgacMsqiGqI3o8BPR+4u/whoRTd" +
       "ptvf+fDMkX26GxwKco2TIoswUYZOv0n41TMoL18kPTb45L4urvY6CN5MAmeD" +
       "uNjh36Mg9nQ7cRxlqQWBU7qZkVRccnRcz9KmPurOcFtt4e8zwSymozMuhucq" +
       "2zv5f1xtN3CcJWwb7cwnBc8TawaMe3/9iz9+jqvbSSlNnlpggLJuTxhDYq08" +
       "YLW4ZrvNpBTg3jzW/+273799J7dZgFhSasMuHHsgfMERgpq/8dze1986f/LV" +
       "cN7OQ4zUGabOwE1oMpeXE5dIY4CcsOFSlyWIhCpQQMPp2q6BiSopBb0Pfetf" +
       "TZeseuy9O5uFKagw41jSyosTcOfnrCO3vbDr7x2cTEjGTOyqzQUT4X2GS3mt" +
       "aUpjyEdu/8sLvvOsdC8kCgjOljJOebwNCTVwyWczsqworiT1jIgtIqjAHtsk" +
       "c4gyftKrOd7lfLwSVcSpEb52NQ6XWF6PKXRKT401KB989YPGHR88dYHLV1ik" +
       "eQ1kk2R0C5vEYWkOyM/yR7QNkpUGuCvPbv5qs3r2Y6AYB4oyxGtriwmBNVdg" +
       "TjZ0Vc0bP326ffdLFSS8ntSrupRcL3HPJHXgEtRKQ0zOGV+8TpjDaC0MzVxU" +
       "UiR80QQeycLSh92bMRg/nvEfzvrBNQ8cP89N0+AkFuTNcRqS6YBnjW2Oa0q7" +
       "HY6X8nE5Dpc5Jl5tZBNQ8fvsuz6AoO9cqzilKvx5VWFmwOg7kE1YEMWVDDjt" +
       "iF3lXNG/W57o6v+9qGDmlEAQcG0PRu/Y8dqeczwk1GKewHncqNGTBSCfeOJR" +
       "s5DjU/gLwfNvfJB/nBDVQmuPXbIsytcshoHGsiygySgUILqv9a3he955SAjg" +
       "r+l8wHTi8Lc+jdx5WDi5KHyXFNWeXhxR/ApxcNiC3C0O2oVjrP/DmX0/enDf" +
       "7YKr1sIyrhe6lId+9cm5yLG3ny9RM0DA1SWWP1PH8yFWF56OEOn6bzb9+GBr" +
       "xXrIMX2kNqspe7O0L+mlCZW7lU14jsstqfmEVzg8GkZCy+EUcGKzO/DfNwbE" +
       "kV04XM+XvoBDrzDjNf+jL+JEjyEW5vHJSqzDCmod3ku76fbUK5//5QN3HRkV" +
       "Sg8wIR/e7H9uURMHfvtRUUzj1UUJq/Lhx6On75nbc+27HN9N84jdlSuuHaFU" +
       "cnGvOJX5W7iz+udhUhMnzbLdu/JSEJJnHPo1y2loob8tWC/svUSj0Z0vY+b7" +
       "zdqzrb/A8NpKJSuwC19N0Q5Ppx2LOv3BLUT4yx4R33BYUZypy2GD1bkmN8M1" +
       "o+GLmVGymMNL7T0uLcPh3kAOy2EDh2OlODQnyeFceFbae6wsw2EukMNy2BA7" +
       "RpWkaNP8XI5Nkst58Kyy91lVhstbA7kshw15Lk2VoTQrxeZtAWx6lHJDfjv+" +
       "V018jag/Rc5z4oxJFpS7K+CB++SBw8eTW+5bFbaj2g4oPJluXKbSEap6SNUh" +
       "pYJgtInfjrie/eb0Q797omto3WR6LpzruEhXhb8XQlhZXj6++Vl59sCf5m67" +
       "Nr17Eu3TQp+W/CS/t+n08zcslQ+F+VWQCDlFV0iFSN2FgabepCxraoVpaEn+" +
       "XNH+yFJ4NtrnutFvhJ5aqtAk8lVTOdTSVZNTW6/8L3t2HoQR52jekI9yGjG7" +
       "UMB/X/K8b2ekQtGKMjv+3Jnj4hwJyK8ncLiLkWn8Bg80DdWSuyd3nkOfRcrl" +
       "83fkldmCa23wWLYyrcmfQznUAGlPBaydxuE+RiqhvfkK172rgvunUgXjthzj" +
       "k1dBOdQAMR8PWHsCh0eFCm7yqeD7U6WCOfDst+XYP3kVlEMNEPNnAWvP4PAT" +
       "RmpBBV/OZz1XDWenSg2YvydsWSYmr4ZyqAGivhSw9goO5yBLgRo2uGnV1cOL" +
       "U6CHGY4eDtrCHJy8HsqhBsh6PmDtbRxeZ6RGlrR+5/NGQCSuSei6SiWtdDR2" +
       "1ffGVJkRJrhjtg6OTV595VB9KvJIdZRT/SBAh3/B4V1G6pOKSNnbdJ8xvTcF" +
       "2uCZHovtE7ZIJyavjXKoAcJ+ErD2KQ4fMdIAThWnpu6melcV/5gCVbTiGhaw" +
       "99vy3D95VZRDLS9uqD5grQGHKig7mC4+722lhlMpNfPLMmw/I2Itr51Q9WfS" +
       "/TMyo8Q3Erynm130XVZ8S5QfPt5UO+v49td42Z3/3tcABXQqq6reRtfzXm2Y" +
       "NKVw5TaItpfff4TaoY8OqgahlREvKEGoTSDNYaStJBKka/znhZ0PSvTDQhfH" +
       "/3vhFoJTunCwrXjxgnRCdQkg+LrEEP4eKux98qbbdrHD8bRLSwraDP7R3GkJ" +
       "suKz+aB85vjGzbdcuOo+8b1AVqXxcaQyLUZqxKeLfFuxuCw1h1b1hmUfT3+k" +
       "7hKnAWsRDLt2P8/jpz0Q2gw0h7m+m3SrK3+h/vrJa556caL65TAJ7SQhCUxq" +
       "Z/G1Sc7IQj+3M1Z8wwYtGL/i71723bFrV6b+/Bt+80vEjdz88vCD8qsP3PzK" +
       "odknO8JkWh+pgt6S5vh9zvVjGpjyiBknjYrVmwMWgYoiqQXXd9PRciX0Ka4X" +
       "W52N+Vn82sRIZ/HdZfE3unpVH6XmOj2rJZFMI7SA7ow4GV9nljUMH4I7Yx8l" +
       "jnGRUfE0wPYGY5sMw7naJScMboM7S6dXNNIr+Su+rf4P70NZe1AjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
