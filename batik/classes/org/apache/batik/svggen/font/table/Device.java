package org.apache.batik.svggen.font.table;
public class Device {
    private int startSize;
    private int endSize;
    private int deltaFormat;
    private int[] deltaValues;
    public Device(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        startSize =
          raf.
            readUnsignedShort(
              );
        endSize =
          raf.
            readUnsignedShort(
              );
        deltaFormat =
          raf.
            readUnsignedShort(
              );
        int size =
          startSize -
          endSize;
        switch (deltaFormat) {
            case 1:
                size =
                  size %
                    8 ==
                    0
                    ? size /
                    8
                    : size /
                    8 +
                    1;
                break;
            case 2:
                size =
                  size %
                    4 ==
                    0
                    ? size /
                    4
                    : size /
                    4 +
                    1;
                break;
            case 3:
                size =
                  size %
                    2 ==
                    0
                    ? size /
                    2
                    : size /
                    2 +
                    1;
                break;
        }
        deltaValues =
          (new int[size]);
        for (int i =
               0;
             i <
               size;
             i++) {
            deltaValues[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfWwUxxUfn41t/IE/+AxgA7ZJxEfukjRphUxJwNhgejYW" +
                                                              "Jo5qCGZub+5uYW93sztnH6Q0CWoErVRECSG0TfxPSSGIhChq1ERtUqqoJFE+" +
                                                              "pHy0aRoF+qU2bYoaVDWtmrbpezO7tx93Z4SqWNq52dn33rw3897vvRmfuUSm" +
                                                              "2RZpZzqP8j0ms6O9Oh+ils2SPRq17a0wNqY8VEn/tuODwVURUj1KZmSoPaBQ" +
                                                              "m/WpTEvao6RN1W1OdYXZg4wlkWPIYjazxilXDX2UzFbt/qypqYrKB4wkQ4IR" +
                                                              "asVJC+XcUhM5zvodAZy0xUGTmNAktjb8uTtOGhTD3OORz/OR9/i+IGXWm8vm" +
                                                              "pDm+i47TWI6rWiyu2rw7b5EVpqHtSWsGj7I8j+7SbnGWYFP8lqIl6Hiy6eNP" +
                                                              "DmeaxRLMpLpucGGevYXZhjbOknHS5I32aixr30W+SirjpN5HzElX3J00BpPG" +
                                                              "YFLXWo8KtG9kei7bYwhzuCup2lRQIU6WBIWY1KJZR8yQ0Bkk1HLHdsEM1i4u" +
                                                              "WCutLDLxwRWxow/taH6qkjSNkiZVH0Z1FFCCwySjsKAsm2CWvTaZZMlR0qLD" +
                                                              "Zg8zS6WautfZ6VZbTeuU52D73WXBwZzJLDGnt1awj2CblVO4YRXMSwmHct6m" +
                                                              "pTSaBlvneLZKC/twHAysU0ExK0XB7xyWqt2qnuRkUZijYGPXl4AAWGuyjGeM" +
                                                              "wlRVOoUB0ipdRKN6OjYMrqengXSaAQ5ocTK/rFBca5Mqu2majaFHhuiG5Ceg" +
                                                              "mi4WAlk4mR0mE5Jgl+aHdsm3P5cGVx+6W9+oR0gF6Jxkiob61wNTe4hpC0sx" +
                                                              "i0EcSMaG5fFjdM5zByOEAPHsELGk+eFXLt+2sv3cS5JmQQmazYldTOFjyonE" +
                                                              "jDcW9ixbVYlq1JqGreLmBywXUTbkfOnOm4AwcwoS8WPU/Xhuy/kv33uafRgh" +
                                                              "df2kWjG0XBb8qEUxsqaqMWsD05lFOUv2k+lMT/aI7/2kBvpxVWdydHMqZTPe" +
                                                              "T6o0MVRtiHdYohSIwCWqg76qpwy3b1KeEf28SQipgYc0wNNG5J/45WR7LGNk" +
                                                              "WYwqVFd1IzZkGWi/HQPEScDaZmIJ8PrdMdvIWeCCMcNKxyj4QYa5H8bTaabH" +
                                                              "UgYiFE1oLLaejasKi6KXmZ+x/DzaN3OiogKWfmE48DWImY2GlmTWmHI0t673" +
                                                              "8hNjr0inwkBwVoaTZTBlVE4ZFVNG5ZRRnDIqpozKKUlFhZhpFk4tNxi2ZzcE" +
                                                              "OiBtw7LhOzftPNhRCZ5lTlTB2iJpRyDj9Hho4EL4mHK2tXHvkgs3vhAhVXHS" +
                                                              "ShWeoxomkLVWGqBJ2e1Eb0MCcpGXEhb7UgLmMstQWBIQqVxqcKTUGuPMwnFO" +
                                                              "ZvkkuAkLQzNWPl2U1J+cOz5x38g9N0RIJJgFcMppAGDIPoTYXcDornD0l5Lb" +
                                                              "dOCDj88e22d4OBBIK242LOJEGzrCvhBenjFl+WL69Nhz+7rEsk8HnOYU4gog" +
                                                              "sD08RwBmul3IRltqweCUYWWphp/cNa7jGcuY8EaEk7aI/ixwi3qMuxZ4ljqB" +
                                                              "KH7x6xwT27nSqdHPQlaIlPDFYfORX77+p8+J5XazR5Mv7Q8z3u1DLBTWKrCp" +
                                                              "xXPbrRZjQPf+8aEHHrx0YJvwWaDoLDVhF7Y9gFSwhbDM979017sXL5x4O+L5" +
                                                              "OYeUnUtA5ZMvGInjpG4KI2G2az19APE0QAX0mq7bdfBPNaVi4GFg/btp6Y1P" +
                                                              "/+VQs/QDDUZcN1p5ZQHe+DXryL2v7PhHuxBToWDG9dbMI5MwPtOTvNay6B7U" +
                                                              "I3/fm23ffpE+AgkBQNhW9zKBqxVOrKNS8yA9CE7ViG6hetLIrlUA1Ow+QGix" +
                                                              "q7cIshtEe3Mx80yXuX9zb15hJiok+FZhs9T2R04wOH1l1Zhy+O2PGkc+ev6y" +
                                                              "MDVYl/kdZYCa3dI3sbk2D+LnhpFtI7UzQHfzucHtzdq5T0DiKEgURm22AFnz" +
                                                              "AbdyqKfV/OqnL8zZ+UYlifSROs2gyT4qIpRMh9BgdgZAOW/eepv0jIlaaJqx" +
                                                              "lyeFhSFiYUi+aAB3Z1Hpfe/Nmlzs1N5n5v5g9cnJC8JFTSljgeCvwjwRgGRR" +
                                                              "3XuocPqtL/z85LeOTcj6YFl5KAzxzfvXZi2x/7f/LFpyAYIlapcQ/2jszMPz" +
                                                              "e9Z8KPg9NELurnxxbgNE93hvOp39e6Sj+mcRUjNKmhWnmh6hWg5jfBQqSNst" +
                                                              "saHiDnwPVoOy9OkuoO3CMBL6pg3joJdToY/U2G8MQR+WH2Q+PIscVFgUhr4K" +
                                                              "IjoDguU60S7H5noXaWpMS4UTFwtBTf0UQjmUpJxafBhCNpiSMe0N5xI2pE81" +
                                                              "C2g57lSSNw3tVA52Df1eesE1JRgk3exTsW+OvLPrVYHFtZigt7qW+9IvJHJf" +
                                                              "ImiWin8KfxXw/BcfVBgHZEXW2uOUhYsLdSF68ZTuGDIgtq/14u6HP3hcGhD2" +
                                                              "vRAxO3j0G59GDx2VACsPF51F9b2fRx4wpDnY3IHaLZlqFsHR98ez+350at8B" +
                                                              "qVVrsFTuhZPg47/4z6vR479+uUSVVqk6B0Q/bEKKDO6NNGj915t+fLi1sg9S" +
                                                              "ez+pzenqXTnWnwz6aI2dS/g2yzu0eH7rmIYbw0nFctgDmZixXY3NoHTCW8si" +
                                                              "2Yag58+DZ7HjpIvLeL50leuwGSp28XLcXJwV0MHxdSSkZ+Yq9VwIzxJnpiVl" +
                                                              "9NSn1LMcNyf1SaZx2odFEy+lq3GVurbD0+HM1lFG19yUupbjdnUVQGkHb48K" +
                                                              "OCCqA+l12+vP/8T+3h+ekt5dCmVC59VTJ2uV97LnBcrgjLcXdJuBqmCJ6CyC" +
                                                              "/OVk2/95lsJbFDrBY2lmZOHEzjNwBEjzjHtU+yzFI0IsLY9fvnWc/H7n6/dM" +
                                                              "dv5G1Bq1qg1JBxC0xJ2Bj+ejMxc/fLOx7QlRzFchEDtxHbxsKb5LCVyRiF1o" +
                                                              "wmaf6I6UrNM2SALHt75WOlNFsBvlkCNVnWpC2h1QJmtiQfBtOzb7Ta/AiUi+" +
                                                              "YCmIaTnaoxk6w2LW/TbLLRML91LwMV8CHdsCpc6AMNWrG96fceR3z3al113N" +
                                                              "wRPH2q9wtMT3RbBfy8tvd1iVF/f/ef7WNZmdV3GGXBTyhrDIxwbOvLzhWuVI" +
                                                              "RFx9yYKm6MosyNQdTBF1FuM5Sw8mhU7PPfZ7sLJCbHCouHdLVnw/NsW349g8" +
                                                              "AL6i4EZLv5iC/LvFNTEO9Jq+8tlxAXxVwllrfAqEzftMKqCR+KsmoZsjH1L6" +
                                                              "CmyCcd5W7nJPVAEn9h+dTG5+9EYX9nZAfcYN83qNjTMtIAoCRl68YNE/r+he" +
                                                              "V95FKk9MNtXOnbz9HRn77n1hAzhkKqdp/rLU1682LZZSxfwNskiV2f0xTjqu" +
                                                              "fB8Ee8ULAXlKcp6BenkqTk6q8MfPcpaTuWVYwHTZ8dM/xUlzmB5UEb9+uqc5" +
                                                              "qfPoQJTs+EmegYoKSLD7rOniSrOHOfIokK8Ibm3Bh2ZfKUv7vKEzAAPiEt8N" +
                                                              "2Zy8xh9Tzk5uGrz78ucflZcaikb37kUp9QDQ8n6lEPZLykpzZVVvXPbJjCen" +
                                                              "L3X9q0Uq7EXBAl8w9UKUmOhe80MnfrurcPB/98Tq5187WP0mJKRtpIICNm8r" +
                                                              "PjTlzRw4/rZ4cT0KECmuIrqXfWfPmpWpv74njqUOQi8sTz+mvH3yzreOzDvR" +
                                                              "HiH1/WQahA7Li9Pc+j36FqaMW6OkUbV786AiSIFEECh2Z2AkULzeF+viLGdj" +
                                                              "YRSvxMDZi+v84otEOMJPMGudkdOTTlqt90YC/11wkTNnmiEGb8SXaxMCNvOy" +
                                                              "uKkciw+YpnsMqr/OFOCilMe0V0UXm9f+B+d8pvXgGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2yYAAA==");
}
