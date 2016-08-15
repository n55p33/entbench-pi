package org.apache.batik.anim.values;
public class AnimatablePathDataValue extends org.apache.batik.anim.values.AnimatableValue {
    protected short[] commands;
    protected float[] parameters;
    protected AnimatablePathDataValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatablePathDataValue(org.apache.batik.dom.anim.AnimationTarget target,
                                   short[] commands,
                                   float[] parameters) { super(
                                                           target);
                                                         this.
                                                           commands =
                                                           commands;
                                                         this.
                                                           parameters =
                                                           parameters;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePathDataValue toValue =
          (org.apache.batik.anim.values.AnimatablePathDataValue)
            to;
        org.apache.batik.anim.values.AnimatablePathDataValue accValue =
          (org.apache.batik.anim.values.AnimatablePathDataValue)
            accumulation;
        boolean hasTo =
          to !=
          null;
        boolean hasAcc =
          accumulation !=
          null;
        boolean canInterpolate =
          hasTo &&
          toValue.
            parameters.
            length ==
          parameters.
            length &&
          java.util.Arrays.
          equals(
            toValue.
              commands,
            commands);
        boolean canAccumulate =
          hasAcc &&
          accValue.
            parameters.
            length ==
          parameters.
            length &&
          java.util.Arrays.
          equals(
            accValue.
              commands,
            commands);
        org.apache.batik.anim.values.AnimatablePathDataValue base;
        if (!canInterpolate &&
              hasTo &&
              interpolation >=
              0.5) {
            base =
              toValue;
        }
        else {
            base =
              this;
        }
        int cmdCount =
          base.
            commands.
            length;
        int paramCount =
          base.
            parameters.
            length;
        org.apache.batik.anim.values.AnimatablePathDataValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePathDataValue(
                target);
            res.
              commands =
              (new short[cmdCount]);
            res.
              parameters =
              (new float[paramCount]);
            java.lang.System.
              arraycopy(
                base.
                  commands,
                0,
                res.
                  commands,
                0,
                cmdCount);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePathDataValue)
                result;
            if (res.
                  commands ==
                  null ||
                  res.
                    commands.
                    length !=
                  cmdCount) {
                res.
                  commands =
                  (new short[cmdCount]);
                java.lang.System.
                  arraycopy(
                    base.
                      commands,
                    0,
                    res.
                      commands,
                    0,
                    cmdCount);
                res.
                  hasChanged =
                  true;
            }
            else {
                if (!java.util.Arrays.
                      equals(
                        base.
                          commands,
                        res.
                          commands)) {
                    java.lang.System.
                      arraycopy(
                        base.
                          commands,
                        0,
                        res.
                          commands,
                        0,
                        cmdCount);
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        for (int i =
               0;
             i <
               paramCount;
             i++) {
            float newValue =
              base.
                parameters[i];
            if (canInterpolate) {
                newValue +=
                  interpolation *
                    (toValue.
                       parameters[i] -
                       newValue);
            }
            if (canAccumulate) {
                newValue +=
                  multiplier *
                    accValue.
                      parameters[i];
            }
            if (res.
                  parameters[i] !=
                  newValue) {
                res.
                  parameters[i] =
                  newValue;
                res.
                  hasChanged =
                  true;
            }
        }
        return res;
    }
    public short[] getCommands() { return commands;
    }
    public float[] getParameters() { return parameters;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        short[] cmds =
          new short[commands.
                      length];
        java.lang.System.
          arraycopy(
            commands,
            0,
            cmds,
            0,
            commands.
              length);
        float[] params =
          new float[parameters.
                      length];
        return new org.apache.batik.anim.values.AnimatablePathDataValue(
          target,
          cmds,
          params);
    }
    protected static final char[] PATH_COMMANDS =
      { ' ',
    'z',
    'M',
    'm',
    'L',
    'l',
    'C',
    'c',
    'Q',
    'q',
    'A',
    'a',
    'H',
    'h',
    'V',
    'v',
    'S',
    's',
    'T',
    't' };
    protected static final int[] PATH_PARAMS =
      { 0,
    0,
    2,
    2,
    2,
    2,
    6,
    6,
    4,
    4,
    7,
    7,
    1,
    1,
    1,
    1,
    4,
    4,
    2,
    2 };
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int k =
          0;
        for (int i =
               0;
             i <
               commands.
                 length;
             i++) {
            sb.
              append(
                PATH_COMMANDS[commands[i]]);
            for (int j =
                   0;
                 j <
                   PATH_PARAMS[commands[i]];
                 j++) {
                sb.
                  append(
                    ' ');
                sb.
                  append(
                    parameters[k++]);
            }
        }
        return sb.
          toString(
            );
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
       "zRVh01K1JqbU5musKWClFoZMZbWJElPU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("h2vhAK5RbkPpWWTF74xS1lppC5cOqNUSq7t+bC9L+sKUM32UzLfhFBlE2UZl" +
       "VkkFcZBS2q0lVEUdNjF4mOFZAwFrgQosN5YT1Mf6407Ft30YZqKmFchKFg7s" +
       "YdMUgzEvVwnKmIwXEy1aoeR2Ph0FS3Oh0IrUqAUpt6E61YRZDDgenoqdZdMa" +
       "ThKqPZQxm5ykrWUkNYcrcmu4bXzZwUiwHFGlniJnVt/z2hqBGqKVzAQjmYWW" +
       "t5lONhNFcAiwvlK71KiVtNgROZhQ1grDsA9+MN8O+rM3tk11Z7Ejd3DOd2kj" +
       "ecE338BOVHrkC+zBRjK0v3d97Gzokb3rI5+5oPyIxP03Or5bHI/44seff0Hj" +
       "fqlydm/7chhBt0Se/9dsPdHta76YGce30N8Drj2+d/ejW+iHgl7/w9TTO0Wd" +
       "2Eo9X1Q4v79t+f7XebSzOLSQt/l+nmwOnp4pOvnLU/ZrX82T/x5BtxbnhoCu" +
       "5GhH6NBG/+ONfGY8oae788wHwPUTe3r6ibdHT0dEOHP+lLKLeQIB8Qw9Io5+" +
       "ljwQ78yZtyreQ+D61J54n3r7xbvzlLK78+S2CLodiDc8/n3zUMDb36qA+QmE" +
       "z+4J+Nm3X8D7Tyl7ME/ujaCLquwO9w+1ndjhvqh4nq3L7qHEP/QWJC5AJh/e" +
       "P78n8c+/PRKfOazw/UK0958i9tU8eW8EXdKs3eEVoThGsjkU8X1vQcQCvPJT" +
       "JC/uifji22/U1illfz1PahF0G/DauR54h+h1KF/9Lch3V555P7h+a0++33r7" +
       "5WufUkblydMAdCJv97GJ14t+v3ko3off0NGNCLrnBsf48wPJ917zN6LdX1/U" +
       "l1+4fPM9L0z+7e7I6P7fU25hoJsXsW0fPZh25PmCH+gLq5D/lt0xNb8QCkzp" +
       "7z5tNoqgC7uHnP0zzK4RmE7fed1GEXQuvx2tO46gKyfrRtD54n60ngiGxWE9" +
       "0O3u4WiVWQTdBKrkj3N/N+LOHI8L9g0B3fVahjgSSjx67MhbcZ5k/3havPuX" +
       "17Pql17oDT76veYv7U7hq7a83eZUbmagi7s/BBRE8yNuD9+Q2j6tC/QTr97x" +
       "5Vse3w9O7tgxfOi8R3h78Prn3UnHj4oT6tvfvOfXP/CPXviT4uvj/wNgg/zM" +
       "fDcAAA==");
}
