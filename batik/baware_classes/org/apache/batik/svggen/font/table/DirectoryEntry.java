package org.apache.batik.svggen.font.table;
public class DirectoryEntry {
    private int tag;
    private int checksum;
    private int offset;
    private int length;
    private org.apache.batik.svggen.font.table.Table table = null;
    protected DirectoryEntry(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        tag =
          raf.
            readInt(
              );
        checksum =
          raf.
            readInt(
              );
        offset =
          raf.
            readInt(
              );
        length =
          raf.
            readInt(
              );
    }
    public int getChecksum() { return checksum; }
    public int getLength() { return length; }
    public int getOffset() { return offset; }
    public int getTag() { return tag; }
    public java.lang.String toString() { return new java.lang.StringBuffer(
                                           ).
                                           append(
                                             (char)
                                               (tag >>
                                                  24 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag >>
                                                  16 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag >>
                                                  8 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag &
                                                  255)).
                                           append(
                                             ", offset: ").
                                           append(
                                             offset).
                                           append(
                                             ", length: ").
                                           append(
                                             length).
                                           append(
                                             ", checksum: 0x").
                                           append(
                                             java.lang.Integer.
                                               toHexString(
                                                 checksum)).
                                           toString(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfnz/xN+b7ywZjSPnIXQihCJmSgLHB9IwtTIhq" +
                                                              "Gsze3tx58d7usjtnn0loE6QUWqmIEgKkSmj/ICVFENKPqE3bIKqoIRFJpSQ0" +
                                                              "NKkgUVM1tClqUNW0Cm3T92Z2bz/Od9RV6Uk7tzfz3sx7b9783ntzp66RUssk" +
                                                              "jVRjYTZiUCvcrrEeybRovE2VLGsz9PXLR4qlv2y7unFFiJT1kdoByeqSJYt2" +
                                                              "KFSNW31klqJZTNJkam2kNI4cPSa1qDkkMUXX+sgkxepMGaoiK6xLj1Mk2CKZ" +
                                                              "UTJeYsxUYmlGO+0JGJkVBUkiXJLI6uBwa5RUy7ox4pJP9ZC3eUaQMuWuZTFS" +
                                                              "H90hDUmRNFPUSFSxWGvGJIsMXR1JqjoL0wwL71CX2SbYEF2WY4LmZ+s+vnFg" +
                                                              "oJ6bYIKkaTrj6lmbqKWrQzQeJXVub7tKU9ZO8iVSHCVVHmJGWqLOohFYNAKL" +
                                                              "Otq6VCB9DdXSqTadq8OcmcoMGQViZI5/EkMypZQ9TQ+XGWaoYLbunBm0nZ3V" +
                                                              "VmiZo+JjiyKHjmyr/34xqesjdYrWi+LIIASDRfrAoDQVo6a1Oh6n8T4yXoPN" +
                                                              "7qWmIqnKLnunGywlqUksDdvvmAU70wY1+ZqurWAfQTczLTPdzKqX4A5l/ypN" +
                                                              "qFISdJ3s6io07MB+ULBSAcHMhAR+Z7OUDCpanJGmIEdWx5bPAwGwlqcoG9Cz" +
                                                              "S5VoEnSQBuEiqqQlI73geloSSEt1cECTkel5J0VbG5I8KCVpP3pkgK5HDAHV" +
                                                              "OG4IZGFkUpCMzwS7ND2wS579ubZx5f4HtPVaiBSBzHEqqyh/FTA1Bpg20QQ1" +
                                                              "KZwDwVi9MHpYmvzCvhAhQDwpQCxofvTg9XsWN557WdDMGIWmO7aDyqxfPh6r" +
                                                              "fX1m24IVxShGhaFbCm6+T3N+ynrskdaMAQgzOTsjDoadwXObXvrCQyfphyFS" +
                                                              "2UnKZF1Np8CPxst6ylBUaq6jGjUlRuOdZBzV4m18vJOUw3tU0ajo7U4kLMo6" +
                                                              "SYnKu8p0/htMlIAp0ESV8K5oCd15NyQ2wN8zBiGkHB5SDc9MIj78m5F4ZEBP" +
                                                              "0YgkS5qi6ZEeU0f9rQggTgxsOxCJgdcPRiw9bYILRnQzGZHADwaoMzCUTFIt" +
                                                              "ktARoaSYSiNrFZOiw48AxpojYfQ24/+0Tgb1nTBcVARbMTMIBCqcofW6Gqdm" +
                                                              "v3wovab9+jP9F4ST4cGwLcXIElg6LJYO86XDYukwLh3mS4f9S5OiIr7iRBRB" +
                                                              "bDxs2yAAACBw9YLe+zds39dcDB5nDJeAzZG02ReJ2lyUcKC9Xz7TULNrzpUl" +
                                                              "L4ZISZQ0SDJLSyoGltVmEiBLHrRPdXUMYpQbKmZ7QgXGOFOXaRyQKl/IsGep" +
                                                              "0Ieoif2MTPTM4AQyPLKR/GFkVPnJuaPDD2/58h0hEvJHB1yyFIAN2XsQ07PY" +
                                                              "3RJEhdHmrdt79eMzh3frLj74wo0TJXM4UYfmoE8EzdMvL5wtPdf/wu4WbvZx" +
                                                              "gN9MgvMG0NgYXMMHP60OlKMuFaBwQjdTkopDjo0r2YCpD7s93FnH8/eJ4Ba1" +
                                                              "zqFssQ8o/8bRyQa2U4Rzo58FtOCh4nO9xpO//uUflnJzO1GlzpMO9FLW6kEy" +
                                                              "nKyBY9Z41203m5QC3eWjPY8+dm3vVu6zQDF3tAVbsG0DBIMtBDM/8vLOt9+9" +
                                                              "cvxiyPVzRsYZps7gpNB4JqsnDpGaAnrCgvNdkQAMVZgBHaflXg1cVEkoeAbx" +
                                                              "bP2jbt6S5/60v164ggo9jictvvkEbv+0NeShC9v+1sinKZIxGLtmc8kEwk9w" +
                                                              "Z15tmtIIypF5+I1Zj5+XnoRYAfhsKbsoh9wi+7ijUFMhcnBORQ9vkrS4nlot" +
                                                              "A85ZHQDefGOXcbI7eHtXLvMEh7mzuz0jUwMF4nwrsJlneQ+P/3x6Mq5++cDF" +
                                                              "j2q2fHT2OlfVn7J5faVLMlqFe2IzPwPTTwmC23rJGgC6u85t/GK9eu4GzNgH" +
                                                              "M3Kluk0A2YzPs2zq0vJ3fv7i5O2vF5NQB6lUdSneIfFDSsbB6aDWAOBzxrj7" +
                                                              "HuEZwxXQ1ONbhmQNQ7hhSCanA3enafR9b08ZjO/Urh9P+eHKE8eucC81xBwz" +
                                                              "OD/WBzN9qMwTfxcYTr65/FcnvnF4WKQOC/KjYYBv6ifdamzPb/+eY3KOg6Ok" +
                                                              "NQH+vsipJ6a3rfqQ87uAhNwtmdwwB6Du8t55MvXXUHPZL0KkvI/Uy3aivUVS" +
                                                              "03jM+yC5tJzsG5Jx37g/URRZUWsWcGcGwdCzbBAK3fAK70iN7zUB9MPMhL80" +
                                                              "2qjQGES/IsJfujjLbbxdiM3tDtiUG6YCxRgNQE1VgUkZKWYgqC8eY8zrTccs" +
                                                              "iJ1KCqByyE4v7+zZLu9r6fmd2P9pozAIuklPR76+5dKOVzkQV2B03uzo7Im9" +
                                                              "EMU9UaBeiPwpfIrg+Rc+KCp2iDStoc3OFWdnk0X034KOGFAgsrvh3cEnrp4W" +
                                                              "CgS9LkBM9x362qfh/YcEtIqKY25O0u/lEVWHUAeb+1C6OYVW4RwdH5zZ/dOn" +
                                                              "d+8VUjX48+d2KA9Pv/XPV8NH33tllFStWLGrRi9gQnz0741QaO1X6352oKG4" +
                                                              "A+J6J6lIa8rONO2M+72z3ErHPJvlVjKux9qq4cYwUrQQ9kBEZWxXYrNRuN/d" +
                                                              "eTFsnd/np8HTZLtnUx6fF65yGzY9uc6dj5uRCshh5UErncLfWwKCDoxR0Cnw" +
                                                              "zLaXmp1HUK2goPm4mVPMjCam/l+IOcdeaE4eMdMFxczHDWKqVEuKoioo5tAY" +
                                                              "xcTNarYXas4j5oMFxczHzUgpL1KczOEz/0E9sxnbgEa7C2iUyQvCZUY6piqy" +
                                                              "i8H8U0YCdac33XNjMEHImJXvaoDDxfE9h47Fu59agnCBjNsgyWS6cbtKh6ga" +
                                                              "COezfOG8i1+GuLHxcu3B959vSa4ZS32FfY03qaDwdxNA2cL8wBwU5fyeP07f" +
                                                              "vGpg+xhKpaaAlYJTfrfr1Cvr5ssHQ/zmRwTtnBsjP1OrHwwrTcrSpuaHv7nZ" +
                                                              "fa3D/ZoOzyJ7XxcFvdj1J+7CX/G7cGUB1kAq7CR4+PtIgbHHsTnISFWSsjYv" +
                                                              "8rlO/ejNjmnhDBM72g3ev99vianwRGx1ImO3RD7WAtoeLzD2HWy+BUcDLBF1" +
                                                              "Mcu1w7dvpR2W2sosHbsd8rEW0PV7BcZ+gM0pYYduN8S4djh9q+wwCZ7ltjLL" +
                                                              "x26HfKwFdD1bYOwcNs8DOoMdNkvJgBF+cguM0IBjCA+ttiatYzdCPtYCil4o" +
                                                              "MPYaNi9BVsR0ce/tRMh6XjRinRP2DHDTnP9fmCbDSK3/xhBL1ak5f1SIy3X5" +
                                                              "mWN1FVOO3XuJB6bsBXg1hJhEWlW9xZTnvcwwaULhelaL0kpkppcYab55AuDL" +
                                                              "Gd4SnO9AlVeIk5ES/PKyXGZkSh4W8D3x4qV/D2wfpAdR+LeX7n1GKl06mEq8" +
                                                              "eEl+D9UAkODrB8YoGysK2EyRP9vI7vOkm+2zJ0GZ6wvs/F8pJwinxf9S/fKZ" +
                                                              "Yxs2PnD9s0+J2zhZlXbtwlmqoMYQF4PZQD4n72zOXGXrF9yofXbcPCflGS8E" +
                                                              "ds/PDI+Tt0MWZqB7TQ/cU1kt2euqt4+vPPvavrI3oKLaSookRiZszS31M0Ya" +
                                                              "Mqit0dxaCpIefoHWuuCbI6sWJ/78G36ZQkTtNTM/fb988cT9bx6cerwxRKo6" +
                                                              "SSlkczTD7yDWjmibqDxk9pEaxWrPgIgwiyKpvkKtFk+ChMeT28U2Z022F+9y" +
                                                              "wdlza9TcG/BKVR+m5ho9rcVxGij1qtweJ6Hz5UJpwwgwuD2eOj6GzX0Z3A3w" +
                                                              "x/5ol2E4JXxVicHhQA4WrLyTc3/CX7G58W8GYVV2sR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sgU4RxIJPme0UqYGKK4qLaLmtHpaM5OoMjLSeoi1FZU+ic8ybCwyAz/zRIup" +
       "SrQgDctCq8cIW5eywondNgim6494dSayc2+46NsSNlzOKK7DzeTRdti3YDqg" +
       "NK9Ma66hI+yYH7PV5nDLM/0RDPxswju9SOZbLQSuNVblVTvudYnKdtuhmwNk" +
       "FgzLGD9HR732Su3avhpiuMZmK1T3mTVWTdzyuDdjq+Jct912o52pbMzUkpBX" +
       "dTiJqtNFLKXLAc4uY5YqD5bzGct2+XqZs/ps1JGJZLhWx6brtdZu2UfmpNfC" +
       "AhztON0GrPWqhFzJNp0gGDZcuLEAlsiIWB1lbq3RCTlyVXU4PPU4GI5E3XJ6" +
       "GVehrMxjObzDTOtme+v0t8Qcl6oVpIzatSEAwumanzdKqo3Gk6ieDVsdNGxO" +
       "FgFVbhE0GxItFm7EAKrwEq7EqbHlJ9komEtegC29AVHtbQKn5VFy0/HJZTxQ" +
       "zWGTnUhLoivr1mxZUSZt09Wai3TBI+tFWBdqcL0cV+rV5dLF1yCbiGOzvYhL" +
       "5YEmrEg8LlUCAwQNnVJMaCsNs52YeCJVaqEd0vTW69RKdEVa10ozxx3Nm/oq" +
       "6C8Cd4UnRgkz1mKHXSkOwY2GeGz6QtUBOXyzUZO6w5amU9xMWdCY1g1nTMy2" +
       "V5idRVl5LSZsp+okftCzHG1Y4mE0rbObWqmktDprZIPo3THCWfrEwXo1XZ4w" +
       "rLXpaAid8Qk/Hic2iaB+j1qS9ahRC2Gqj2tRlcoGyy6L9q3ILDeRecYHSLYp" +
       "xz1UjzGjxiFxpzYYEnVLVAVHo/VOSwgWRF1uTZsckaX+GutGbSlJZ8MKN1is" +
       "7OFgiK1WAik7TVRzZH2EL8oNac3Bor/C+ZLW7bcbWqSQjUpKJBnXgqdENsA3" +
       "bDLWU2U+9us1uKM4YK2qTvtDjoT76/mciOuGrsp2xi/gkjZH+9yyzpmDYbcU" +
       "B4bXq8uor2+GDSxqrgZJaKtJQtRbUSOs1dh4NhO7vMSU+2ZMw+IWlY1YnAhl" +
       "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");
}
