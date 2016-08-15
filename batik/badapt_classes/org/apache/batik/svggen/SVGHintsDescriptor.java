package org.apache.batik.svggen;
public class SVGHintsDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String colorInterpolation;
    private java.lang.String colorRendering;
    private java.lang.String textRendering;
    private java.lang.String shapeRendering;
    private java.lang.String imageRendering;
    public SVGHintsDescriptor(java.lang.String colorInterpolation, java.lang.String colorRendering,
                              java.lang.String textRendering,
                              java.lang.String shapeRendering,
                              java.lang.String imageRendering) { super(
                                                                   );
                                                                 if (colorInterpolation ==
                                                                       null ||
                                                                       colorRendering ==
                                                                       null ||
                                                                       textRendering ==
                                                                       null ||
                                                                       shapeRendering ==
                                                                       null ||
                                                                       imageRendering ==
                                                                       null)
                                                                     throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                                       org.apache.batik.svggen.ErrorConstants.
                                                                         ERR_HINT_NULL);
                                                                 this.
                                                                   colorInterpolation =
                                                                   colorInterpolation;
                                                                 this.
                                                                   colorRendering =
                                                                   colorRendering;
                                                                 this.
                                                                   textRendering =
                                                                   textRendering;
                                                                 this.
                                                                   shapeRendering =
                                                                   shapeRendering;
                                                                 this.
                                                                   imageRendering =
                                                                   imageRendering;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_COLOR_INTERPOLATION_ATTRIBUTE,
            colorInterpolation);
        attrMap.
          put(
            SVG_COLOR_RENDERING_ATTRIBUTE,
            colorRendering);
        attrMap.
          put(
            SVG_TEXT_RENDERING_ATTRIBUTE,
            textRendering);
        attrMap.
          put(
            SVG_SHAPE_RENDERING_ATTRIBUTE,
            shapeRendering);
        attrMap.
          put(
            SVG_IMAGE_RENDERING_ATTRIBUTE,
            imageRendering);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZa2wU1xW+u8bvtwFDeBhs1kYYshvaQEsMNLAYMKyNaxtL" +
       "XR7L7Ozd3cGzM8PMXXvtJC0gpaGPIEoI0CrwoyXlERqiqmmatESOouahpJVI" +
       "SNM0CkVNfyRNUYKipFXp69w7MzuPfSDSZqW5e/fOOeeec+653zn37vlrqFRT" +
       "UQuWiJ+MK1jzd0ukn1M1HAuKnKYNwViEP1bCfbzzvb4VXlQWRnVJTuvlOQ2v" +
       "F7AY08JoriBphJN4rPVhHKMc/SrWsDrKEUGWwmi6oPWkFFHgBdIrxzAlGObU" +
       "EGrkCFGFaJrgHkMAQXNDoEmAaRJY437dFUI1vKyMW+QzbeRB2xtKmbLm0ghq" +
       "CO3mRrlAmghiICRopCujosWKLI4nRJn4cYb4d4vLDBdsCi3LcUHbE/Wf3jiU" +
       "bGAumMpJkkyYedoA1mRxFMdCqN4a7RZxStuDvo5KQqjaRkyQL2ROGoBJAzCp" +
       "aa1FBdrXYimdCsrMHGJKKlN4qhBBrU4hCqdyKUNMP9MZJFQQw3bGDNbOz1qr" +
       "W5lj4sOLA0eO7Wz4aQmqD6N6QRqk6vCgBIFJwuBQnIpiVVsTi+FYGDVKsNiD" +
       "WBU4UZgwVrpJExISR9Kw/KZb6GBawSqb0/IVrCPYpqZ5IqtZ8+IsoIxfpXGR" +
       "S4CtzZatuoXr6TgYWCWAYmqcg7gzWKaMCFKMoHlujqyNvs1AAKzlKUyScnaq" +
       "KRIHA6hJDxGRkxKBQQg9KQGkpTIEoErQrIJCqa8Vjh/hEjhCI9JF16+/AqpK" +
       "5gjKQtB0NxmTBKs0y7VKtvW51rfy4D3SRsmLPKBzDPMi1b8amFpcTAM4jlUM" +
       "+0BnrOkMHeWaLx7wIgTE013EOs1T916/e0nL5Es6zew8NFuiuzFPIvypaN2l" +
       "OcFFK0qoGhWKrAl08R2Ws13Wb7zpyiiAMM1ZifSl33w5OfDC1/aewx94UVUP" +
       "KuNlMZ2COGrk5ZQiiFjdgCWscgTHelAllmJB9r4HlUM/JEhYH90Sj2uY9KAp" +
       "Ihsqk9lvcFEcRFAXVUFfkOKy2Vc4kmT9jIIQKocHBeFpRfqHfRO0I5CUUzjA" +
       "8ZwkSHKgX5Wp/VoAECcKvk0GohD1IwFNTqsQggFZTQQ4iIMkNl+MJhJYCgwO" +
       "b9gIkaqtwxqvCgrEu5+GmfJ5T5ChFk4d83jA+XPcW1+EXbNRFmNYjfBH0mu7" +
       "rz8eeUUPK7oVDN8Q1Alz+vU5/WxOvz6nP3dO5PGwqabRufU1hhUagb0OYFuz" +
       "aHDHpl0H2koguJSxKeBeStrmSDpBCxBMFI/wF5pqJ1qvLH3ei6aEUBPHkzQn" +
       "0hyyRk0AOvEjxgauiUI6srLCfFtWoOlMlXkcA1AqlB0MKRXyKFbpOEHTbBLM" +
       "nEV3Z6BwxsirP5o8PrZv+Bt3eJHXmQjolKWAYZS9n8J3FqZ9bgDIJ7f+gfc+" +
       "vXD0PtmCAkdmMRNiDie1oc0dDG73RPjO+dyTkYv3+ZjbKwGqCQdbC1CwxT2H" +
       "A2m6TNSmtlSAwXFZTXEifWX6uIokVXnMGmFR2sj60yAsqunWmwvPYmMvsm/6" +
       "tlmh7Qw9qmmcuaxgWWHVoHLi9799/4vM3WYCqbdl/kFMumygRYU1MXhqtMJ2" +
       "SMUY6N453v/Qw9ce2MZiFigW5JvQR9sggBUsIbj5/pf2vPXHK6cue604J5C1" +
       "01EofjJZI+k4qipiJMzWYekDoCcCLtCo8W2VID6FuMBFRUw31j/r25c++deD" +
       "DXociDBihtGSmwuwxm9bi/a+svNvLUyMh6dJ1/KZRaYj+VRL8hpV5capHpl9" +
       "r839/ovcCcgJgMOaMIEZtJYyH5Qyy2dCDcY4aX716/mVji93NWyFlzGWO1h7" +
       "J/UOE4TYuxW0adfsO8W5GW2VVIQ/dPmj2uGPnr3OTHOWYvbA6OWULj0WadOR" +
       "AfEz3Ei2kdOSQHfnZN/2BnHyBkgMg0QesFnbogKUZhxhZFCXlv/hueebd10q" +
       "Qd71qEqUudh6ju1IVAlbAWtJQOGM8pW79UgYq4CmgZmKcozPGaCrMS//Onen" +
       "FMJWZuIXM3628vTJKywkFV3GbGNZIDE4IJgV9BYKnHv9S2+c/t7RMb0kWFQY" +
       "+lx8M/+xRYzu/9Pfc1zOQC9PueLiDwfOPzIruPoDxm+hD+X2ZXKTGSC4xfuF" +
       "c6lPvG1lv/ai8jBq4I0CepgT03RPh6Fo1MyqGopsx3tnAahXO11ZdJ3jRj7b" +
       "tG7cs5Io9Ck17de6oK6GLmEHPG0GCrS5oc6DWGczY1nI2k7a3G4iS7miCnDI" +
       "wi5oqS4iFIyEIosmBKhqwSLOhMHlOrDS9i7ahHShqwpGZrfTEjrRAmPSBQUs" +
       "GdItoU1frsqFuAmqYyoPQKmHHahhU3frLapLazyfMaGvgLrbiqpbiJugWnpe" +
       "Kqrt9s/g3HZjvvYC2kaLaluIG5yrJTkFF1WX/wzqdhgTdhRQVyiqbiFuUFdI" +
       "wWmqqLq7i6ibsaZdnJ2WfcqQ6wRgT8gWanrNZNZepDa2ymKTurUI9eA4IFyG" +
       "ppy5hQ5/7OB6av+Rk7Etjy7V8bjJeaDqltKpn/zuX6/6j199OU8lX0lk5XYR" +
       "j2LRYQtM6cgAvexcbMHpO3WH333al1h7K/U3HWu5SYVNf88DIzoLJxW3Ki/u" +
       "/8usodXJXbdQSs9zudMt8mzv+Zc3dPCHvewSQMf5nMsDJ1OXE92rVEzSqjTk" +
       "wPgF2cCqp3HUAs9qI7BWu3eDFbqumMwWiYVYXRWSJ3ussq0oXarBdFQjA9wY" +
       "i6UIv31hQ7NvxcdtehC15KG13Tgc/OUz4fDCBl4nbssn2HnTcOZ0Bf926oU/" +
       "6wy35WHQ6aafCTw4/ObuV9liVtDoybrQFjkQZbZTQkPWN3XUFY3wXDV8w74J" +
       "2v4/HqiBLRUgQgpwJTAkpHCMXuNRG4wD++cqn5Wcjs1oLdpjI+KaD7/841W6" +
       "W1sLbBqL/umvXr10YuLCeR0IqHsJWlzo4jH3tpOeEtuLnHStAPlkw12T7787" +
       "vMNr1OZ1tPlOxkS9Wqs4hVKYDj6UJ2CnOcNEl7zuW/W/OtRUsh6QpwdVpCVh" +
       "Txr3xJy7r1xLR21xY92vWXvRCJr/wMcDz7/pQ4OFDuhB0xQ07prmZy+boE6m" +
       "7wnydEKXybm/yIHkEdrshfNEApPsnbVh77ettLTvZlm0eK1PB4IKG783uxMY" +
       "+3x4Nhs7YfOtA0wh1gIAQ39/07kVm+A5a0g5a0r5LpPyoG7JQdqczcZFnf1o" +
       "pZ9ZH3NPRH8e051/uojzL9Dmh3C2BOevw3FBYgd7qPXp+BnL+z/6f3g/A+GS" +
       "e/VFj2Ezcy7X9Qth/vGT9RUzTm59k2XQ7KVtDaBePC2K9oOCrV+mqGAKs69G" +
       "PzYo7OspgmYUKCQIKtM7TPef6/TPgF/c9ASVsm873UWCqiw6EKV37CSTBJUA" +
       "Ce0+p+Q50OvnpYzHVl4YfmTun34z92dZ7DctFHrYnxsmPKT7DYS7cHJT3z3X" +
       "lz+q3/TwIjcxQaVUAyjol07ZIqC1oDRTVtnGRTfqnqhsN0GsUVfY2jmzbfEW" +
       "hNBU6IrPcl2DaL7sbchbp1Y++5sDZa8B/G5DHo6gqdtyT5YZJQ25elsoF/yg" +
       "YGL3M12LfjC+ekn8w7fZ2d0AyzmF6SP85dM7Xj8881SLF1X3oFIoGXGGHXnX" +
       "jUsDmB9Vw6hW0LozoCJIETjRgax1NDg5WlQzvxjurM2O0ntCgtpy/t/Ic7ta" +
       "JcpjWF0rp6WYgc3V1ojjXxezjkoriovBGrHVAEdpczyjI3dJJNSrKCaSV1cr" +
       "bJceyw8ktL3MurR547/i5q/L+BwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tu/OJwAA");
}
