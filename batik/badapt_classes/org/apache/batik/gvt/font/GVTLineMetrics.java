package org.apache.batik.gvt.font;
public class GVTLineMetrics {
    protected float ascent;
    protected int baselineIndex;
    protected float[] baselineOffsets;
    protected float descent;
    protected float height;
    protected float leading;
    protected int numChars;
    protected float strikethroughOffset;
    protected float strikethroughThickness;
    protected float underlineOffset;
    protected float underlineThickness;
    protected float overlineOffset;
    protected float overlineThickness;
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics) { super(
                                                                     );
                                                                   this.ascent =
                                                                     lineMetrics.
                                                                       getAscent(
                                                                         );
                                                                   this.
                                                                     baselineIndex =
                                                                     lineMetrics.
                                                                       getBaselineIndex(
                                                                         );
                                                                   this.
                                                                     baselineOffsets =
                                                                     lineMetrics.
                                                                       getBaselineOffsets(
                                                                         );
                                                                   this.
                                                                     descent =
                                                                     lineMetrics.
                                                                       getDescent(
                                                                         );
                                                                   this.
                                                                     height =
                                                                     lineMetrics.
                                                                       getHeight(
                                                                         );
                                                                   this.
                                                                     leading =
                                                                     lineMetrics.
                                                                       getLeading(
                                                                         );
                                                                   this.
                                                                     numChars =
                                                                     lineMetrics.
                                                                       getNumChars(
                                                                         );
                                                                   this.
                                                                     strikethroughOffset =
                                                                     lineMetrics.
                                                                       getStrikethroughOffset(
                                                                         );
                                                                   this.
                                                                     strikethroughThickness =
                                                                     lineMetrics.
                                                                       getStrikethroughThickness(
                                                                         );
                                                                   this.
                                                                     underlineOffset =
                                                                     lineMetrics.
                                                                       getUnderlineOffset(
                                                                         );
                                                                   this.
                                                                     underlineThickness =
                                                                     lineMetrics.
                                                                       getUnderlineThickness(
                                                                         );
                                                                   this.
                                                                     overlineOffset =
                                                                     -this.
                                                                        ascent;
                                                                   this.
                                                                     overlineThickness =
                                                                     this.
                                                                       underlineThickness;
    }
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics,
                          float scaleFactor) {
        super(
          );
        this.
          ascent =
          lineMetrics.
            getAscent(
              ) *
            scaleFactor;
        this.
          baselineIndex =
          lineMetrics.
            getBaselineIndex(
              );
        this.
          baselineOffsets =
          lineMetrics.
            getBaselineOffsets(
              );
        for (int i =
               0;
             i <
               baselineOffsets.
                 length;
             i++) {
            this.
              baselineOffsets[i] *=
              scaleFactor;
        }
        this.
          descent =
          lineMetrics.
            getDescent(
              ) *
            scaleFactor;
        this.
          height =
          lineMetrics.
            getHeight(
              ) *
            scaleFactor;
        this.
          leading =
          lineMetrics.
            getLeading(
              );
        this.
          numChars =
          lineMetrics.
            getNumChars(
              );
        this.
          strikethroughOffset =
          lineMetrics.
            getStrikethroughOffset(
              ) *
            scaleFactor;
        this.
          strikethroughThickness =
          lineMetrics.
            getStrikethroughThickness(
              ) *
            scaleFactor;
        this.
          underlineOffset =
          lineMetrics.
            getUnderlineOffset(
              ) *
            scaleFactor;
        this.
          underlineThickness =
          lineMetrics.
            getUnderlineThickness(
              ) *
            scaleFactor;
        this.
          overlineOffset =
          -this.
             ascent;
        this.
          overlineThickness =
          this.
            underlineThickness;
    }
    public GVTLineMetrics(float ascent, int baselineIndex,
                          float[] baselineOffsets,
                          float descent,
                          float height,
                          float leading,
                          int numChars,
                          float strikethroughOffset,
                          float strikethroughThickness,
                          float underlineOffset,
                          float underlineThickness,
                          float overlineOffset,
                          float overlineThickness) {
        super(
          );
        this.
          ascent =
          ascent;
        this.
          baselineIndex =
          baselineIndex;
        this.
          baselineOffsets =
          baselineOffsets;
        this.
          descent =
          descent;
        this.
          height =
          height;
        this.
          leading =
          leading;
        this.
          numChars =
          numChars;
        this.
          strikethroughOffset =
          strikethroughOffset;
        this.
          strikethroughThickness =
          strikethroughThickness;
        this.
          underlineOffset =
          underlineOffset;
        this.
          underlineThickness =
          underlineThickness;
        this.
          overlineOffset =
          overlineOffset;
        this.
          overlineThickness =
          overlineThickness;
    }
    public float getAscent() { return ascent;
    }
    public int getBaselineIndex() { return baselineIndex;
    }
    public float[] getBaselineOffsets() {
        return baselineOffsets;
    }
    public float getDescent() { return descent;
    }
    public float getHeight() { return height;
    }
    public float getLeading() { return leading;
    }
    public int getNumChars() { return numChars;
    }
    public float getStrikethroughOffset() {
        return strikethroughOffset;
    }
    public float getStrikethroughThickness() {
        return strikethroughThickness;
    }
    public float getUnderlineOffset() { return underlineOffset;
    }
    public float getUnderlineThickness() {
        return underlineThickness;
    }
    public float getOverlineOffset() { return overlineOffset;
    }
    public float getOverlineThickness() {
        return overlineThickness;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fV/jtnxVzsS9L/RCr/FHfDr8X9J274/cMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p8BDyVWMR6rWSsfrPuRgntQZTIwylSAM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zMJJSDhIt9YcLepI5G5G2tzVW+Ga9QKYS5LIhMfNqme4NXhTR/UJMSfKGt5v" +
       "+BOsuVhxFEpujE0qtJpJb4KURBst4U6/35tYnKHYc7lcEvsrUoOlGq8t8VWE" +
       "BFUz0mN9WbFTFZJ7ZZ9GeRNZi6o/bjeHfjKtwNYMYsvBPK55qNLq8PMh3I+r" +
       "KTvlNjGcyjbaUCqyoSxsRyYHjr+sJ+N+XYfmHUVN5FpJK5bWMNeMJAFqjoRZ" +
       "RA4W7LwBKTDmFb0KX5wEOOq4Nc1vJAMITKlOrCRKdRMG7NCYJ0x3tB4nRUUo" +
       "GZUaJgG5KzUklTSDBSuOkKmwdqmnrLVqrduzlsFybHm1MrFc85ZMDCWzQS8G" +
       "06k2TJdgJV+yiguoZ634Bb/EJ4otrpByA6bXSq0lWM1gAIKUoCPzHFEeN0Yc" +
       "WHOgZdavTs2F08NTSuxp0khMnGK3523i+nI2r6KpZpe6JYddGjw8j9yU34Sj" +
       "WhcekgHcaBlUgE9rbbSKwSo7IPLXbf/9xl7hPZi/rTw8HD13qlnGX93AW7r0" +
       "yL7x4Rve/O/OwokDtUfe8B7ZYi1kh4geO+vMc36A6FPve+lljfuV4sXd9m4r" +
       "KtwTef4PO3qiO0ea2p5i8g9h5FCy0yjv38F4/8kXzXuip79lfutWUGdvNV+4" +
       "65y8e7LkIgALFhrEflvwULAXbrvhY0p7cpeyh9n280/tyP3UrSf38Dl5r8mS" +
       "B6LCZUCufs1m8Z7jpZvg+HD2MNvRe2nH8aVbz/Hxc/Iytb7waFR46AjHo7vO" +
       "e5ZvuAmWuZpme5g/t2P5c7eeJXRO3g9nyZujwr2AJaWfpqdvuVl2mRH+8o7d" +
       "L996dtVz8mpZgm6NsLXfB9+TK92KofvMjtxnbj058pw8Okvevh267pEN9T27" +
       "H7lZF5MN3W/s2P3GrWfHnZM3yJJ2VHgVYNc7ujO/p9e52cHL9nC/uKP3xVtP" +
       "753n5P1YlvBR4RFAb3TGFv+eqXCzTLMd4N/ZMf2dW890dk6elSVKVHj9SabH" +
       "92z3ZNWbJZttfX95R/bLt55seE5enCXudtKYnHLoYM/Su1mW2Sb6H+1Y/tGt" +
       "Z/kT5+S9N0s2UeE1R1meNZzvvlmi2Zmsr+2Ifu3WE/3wOXn/IEs+AEJlQJS7" +
       "9hjEnuQHb5ZkFuj8+Y7kn996kj97Tt4ns+RjUeHVR0ieNZg/fUOHKaPCA8c/" +
       "Fsu+fHndNR+ibj+eVD/38qW7X/vy5E+359EPPnC8p1u424gd5+hB4iP3d/qB" +
       "blg5/3u2x4r9nNQvAYdz5idsUeH27F8G+MIvbsv/Y8D/tPJR4TaQHi35aRD2" +
       "niwZFe7I/x8t9xkwM+/LZSc985ujRV4BrYMi2e1nt/pw/JDI9uR1uv3053VH" +
       "tSdfmj30/QbjyCLr6WNHmPNPhg+OG8fbj4ZfUD//crv37u9WfmX74ZfqyJtN" +
       "1srd3cJd22/Q8kazI8tPntnaQVt3tp793gO/fs8zB8u2B7aA95p8BNvjp39l" +
       "RS/8KP8uavPF1/7m23715a/nZ1b+P+97rzrLPQAA");
}
