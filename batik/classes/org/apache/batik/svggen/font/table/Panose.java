package org.apache.batik.svggen.font.table;
public class Panose {
    byte bFamilyType = 0;
    byte bSerifStyle = 0;
    byte bWeight = 0;
    byte bProportion = 0;
    byte bContrast = 0;
    byte bStrokeVariation = 0;
    byte bArmStyle = 0;
    byte bLetterform = 0;
    byte bMidline = 0;
    byte bXHeight = 0;
    public Panose(byte[] panose) { super();
                                   bFamilyType = panose[0];
                                   bSerifStyle = panose[1];
                                   bWeight = panose[2];
                                   bProportion = panose[3];
                                   bContrast = panose[4];
                                   bStrokeVariation = panose[5];
                                   bArmStyle = panose[6];
                                   bLetterform = panose[7];
                                   bMidline = panose[8];
                                   bXHeight = panose[9]; }
    public byte getFamilyType() { return bFamilyType; }
    public byte getSerifStyle() { return bSerifStyle; }
    public byte getWeight() { return bWeight; }
    public byte getProportion() { return bProportion; }
    public byte getContrast() { return bContrast; }
    public byte getStrokeVariation() { return bStrokeVariation; }
    public byte getArmStyle() { return bArmStyle; }
    public byte getLetterForm() { return bLetterform; }
    public byte getMidline() { return bMidline; }
    public byte getXHeight() { return bXHeight; }
    public java.lang.String toString() { java.lang.StringBuffer sb = new java.lang.StringBuffer(
                                           );
                                         sb.append(java.lang.String.
                                                     valueOf(
                                                       bFamilyType)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bSerifStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bWeight)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bProportion)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bContrast)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bStrokeVariation)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bArmStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bLetterform)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bMidline)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bXHeight));
                                         return sb.toString(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1afXQU1RV/uwkhJIR88CkkISRBD6C7YrFiQ1USEhPdQCSI" +
                                                              "NKBhdvYlGTI7M8y8DRssVTm1oufUgxaV9mj6R1GsB8Vj9fTDj2I99eNobVWq" +
                                                              "tVattaf1o7Zweqo9pdbe+97szuzsztClTXPOvJ289+679/7ufffeNzOHPiJT" +
                                                              "LJM0Uo1F2LhBrUinxvok06KJDlWyrA3QNyjfUSL99ar31p4fJmUDZMaIZPXK" +
                                                              "kkW7FKomrAHSoGgWkzSZWmspTSBFn0ktao5JTNG1ATJbsXqShqrICuvVExQn" +
                                                              "bJTMGKmVGDOVeIrRHnsBRhpiIEmUSxJd7R1ui5Hpsm6MO9PnuaZ3uEZwZtLh" +
                                                              "ZTFSE9smjUnRFFPUaEyxWFvaJMsMXR0fVnUWoWkW2aaea0NwSezcPAiaH6z+" +
                                                              "+MTekRoOwUxJ03TG1bPWU0tXx2giRqqd3k6VJq3t5CukJEYqXZMZaY1lmEaB" +
                                                              "aRSYZrR1ZoH0VVRLJTt0rg7LrFRmyCgQI4tyFzEkU0ray/RxmWGFcmbrzolB" +
                                                              "26astkLLPBVvWxbdd8dVNQ+VkOoBUq1o/SiODEIwYDIAgNJknJrW6kSCJgZI" +
                                                              "rQbG7qemIqnKTtvSdZYyrEksBebPwIKdKYOanKeDFdgRdDNTMtPNrHpD3KHs" +
                                                              "/6YMqdIw6DrH0VVo2IX9oGCFAoKZQxL4nU1SOqpoCUYWeimyOrZeChOAdGqS" +
                                                              "shE9y6pUk6CD1AkXUSVtONoPrqcNw9QpOjigych830URa0OSR6VhOoge6ZnX" +
                                                              "J4Zg1jQOBJIwMts7ja8EVprvsZLLPh+tXXXz1Vq3FiYhkDlBZRXlrwSiRg/R" +
                                                              "ejpETQr7QBBOXxq7XZrz+J4wITB5tmeymPP9Lx+/6MzGI8+KOQsKzFkX30Zl" +
                                                              "NigfiM94qb5jyfklKEa5oVsKGj9Hc77L+uyRtrQBEWZOdkUcjGQGj6x/+kvX" +
                                                              "3kc/DJOKHlIm62oqCX5UK+tJQ1GpeTHVqCkxmugh06iW6ODjPWQq3McUjYre" +
                                                              "dUNDFmU9pFTlXWU6/x8gGoIlEKIKuFe0IT1zb0hshN+nDULIVLjIdLhOI+KP" +
                                                              "/zKyJTqiJ2lUkiVN0fRon6mj/lYUIk4csB2JxsHrR6OWnjLBBaO6ORyVwA9G" +
                                                              "aGZgbHiYatEhHSOUFFcpuIKmWzSCXmZM8vpp1G/mjlAIoK/3bnwV9ky3riao" +
                                                              "OSjvS7V3Hn9g8HnhVLgRbGQYWQIsI4JlhLOMCJYRZBnhLCOCJQmFOKdZyFoY" +
                                                              "GMwzChsdIu30Jf1XXrJ1T3MJeJaxoxSwxanNORmnw4kGmRA+KB+uq9q56K3l" +
                                                              "T4VJaYzUSTJLSSomkNXmMIQmedTevdPjkIuclNDkSgmYy0xdpgmISH6pwV6l" +
                                                              "XB+jJvYzMsu1QiZh4daM+qeLgvKTI/t3XLfxmrPDJJybBZDlFAhgSN6HsTsb" +
                                                              "o1u9u7/QutU3vPfx4dt36U4cyEkrmWyYR4k6NHt9wQvPoLy0SXpk8PFdrRz2" +
                                                              "aRCnmQT7CkJgo5dHTphpy4Rs1KUcFB7SzaSk4lAG4wo2Yuo7nB7upLX8fha4" +
                                                              "xTTcd9VwnWFvRP6Lo3MMbOcKp0Y/82jBU8IX+427fvXi+5/jcGeyR7Ur7fdT" +
                                                              "1uaKWLhYHY9NtY7bbjAphXlv7u/7xm0f3bCZ+yzMaCnEsBXbDohUYEKA+fpn" +
                                                              "t7/+9lsHjoYdP2eQslNxqHzSWSXDqFN5gJLA7XRHHoh4KkQF9JrWyzXwT2VI" +
                                                              "wY2HG+uf1YuXP/Knm2uEH6jQk3GjM0++gNN/Wju59vmrPmnky4RkzLgOZs40" +
                                                              "EcZnOiuvNk1pHOVIX/dywzefke6ChABB2FJ2Uh5XQ9m97qoucT/1p+IW49Qi" +
                                                              "9WypfPrH1nf+8JBIPc0FJnvy2b0Hy+U3kk//XhCcVoBAzJt9b/TrG1/b9gL3" +
                                                              "iHIME9iPIFW5ggCEE5c71mQtVY+GaQINHhOGEr+MyP9l3I6bSmKYRttBnH7Z" +
                                                              "VAwGhUanNqaYupZEVez08P9gkwbjLPaPai4bTdzT8uI1Ey3vgJMMkHLFgsgJ" +
                                                              "uBWoV1w0xw69/eHLVQ0P8EBSivDb0OcWevl1XE55xq1Sjc0X0lZh9+gzlSRs" +
                                                              "6THbPc7p2yrvae3j7oF0K4VJP4O/EFz/wgtNiR3CpHUddr3RlC04DAO5LQk4" +
                                                              "IeQyje6qe3v0zvfuFz7pLcg8k+mefTd9Frl5n9i5omptySsc3TSichUeik07" +
                                                              "SrcoiAun6Prj4V2P3rvrBiFVXW4N1glHjPtf/fSFyP7fPlcg/ZfGx5kwyYqc" +
                                                              "3Twr1wJCozU3Vj+2t66kC2zdQ8pTmrI9RXsS7iXBrFYq7tqATjnMO9y6oWUY" +
                                                              "CS1FI+QLUJ9TOvBTqJO97nvlvF8evOX2HULjAPt56Ob9Y50a3/27v3Mg8pJ1" +
                                                              "AZN66Aeih+6c33HBh5zeyZpI3ZrOr8Fg/zi059yX/Fu4ueynYTJ1gNTI9qlv" +
                                                              "o6SmMBcNwA6xMkdBOBnmjOeeWkSJ3patCuq9PuVi683XbkuVshyr1IrdFyI8" +
                                                              "Q13BKc7g7VJszuKWCeNthMGiiiapnK4d8p9KtWE2wievsR0Xf7oZKYF9j7cX" +
                                                              "uowcFkvx/+cxO9uganAO0jWKiSszJmpNRY9kz6AwWMhdGnLcpZeHFgf7N2fc" +
                                                              "+u4PW4fbiykysa/xJGUk/r8QDL/U3wO9ojyz+4P5Gy4Y2VpEvbjQ41beJb/b" +
                                                              "e+i5i0+Xbw3zY65wirzjcS5RW64rVJgUzvNa7jZtEQ7BrSe8AZtl3L78/7Oz" +
                                                              "diDcDiIQqwFjvBxTwH1kNLTwi4Dp2/N6sTpZWLju6UwajFcqO38w9+FVByfe" +
                                                              "4iWakSZeb8F/16Y5g3MDmO/AZrHlLtdzjet6ljMo7z16rGrjsSeO50WW3Oq0" +
                                                              "VzLanN12Osb3ud7jVLdkjcC8FUfWbqlRj5zgybhSkiFzWutMOM6lc2pZe/aU" +
                                                              "qb9+8qk5W18qIeEuUqHqUqJL4scCMg3qcWqNwEkwbVx4kahydmBtWsNVJXnK" +
                                                              "54OOHczewAt4ZwW/vyy34J0L1wK74F3grertuHJd4bhCPLVzOGApRirjXVJS" +
                                                              "Uccz/rpaHBmw5eDuFqtd7atuAcHrbW71PoLf6GyBr+bL6keNsmLoGupn42pB" +
                                                              "WW8qUtaZcDXY3Bp8ZN0bKKsfNSNT41dQZXiEFZLzllPAtNHm1Ogj5x2BcvpR" +
                                                              "I6ZQKBu6mTngeWXdX6Sss+FaaHNb6CPrRKCsftSMTIvjs1VTsgqi+u0iJUX/" +
                                                              "arJ5NflIenegpH7UjNTE+5mpj2KiUyQ/aO85BWgX2SwX+Qh8KFBgP2qEdrWZ" +
                                                              "9N1Y95+CwzbbvJp9JP1eoKR+1OiwMcrw/KObyUKyPlykrHjTYnNr8ZH1R4Gy" +
                                                              "+lEzOEL3Kgl8yFpI0EdPQdBWm1Wrj6BPBgrqR42Cbur2DVc/CRA07apmsgz5" +
                                                              "XxnxPCB2MXRlP4J5u8HvGT4/kx3YvW8ise7u5ZnjaQ+4K9ONs1Q6RlXXUpX8" +
                                                              "nmbFmIHLY8ZbYYuxwouao6hHg+xDJz/SgGLnaMDYq9j8nJGqYco8edfB+xcn" +
                                                              "c4z/pMLww2KlrdDK4rHwIw3Q952AsXex+Y3AwpPXHSzenCwsMEStshVaVTwW" +
                                                              "fqQB+v45YOwYNu+DXwMWrrrBweGDyfQJe03xWxwOfqQBup4IGPsUm4+FT3jq" +
                                                              "EgeLTyYLCwxTa2yF1hSPhR+pv76h8oCxCmxKIOEBFjl1TxaJUOlkIdEEV7et" +
                                                              "TnfxSPiRBmg7O2BsLjY1jNRhpChQVzmA1E6ma8RsrWLFA+JHGqB0c8BYKzYN" +
                                                              "wjVy6jYHicbJDBh9tjp9xSPhRxqgbTRgbDk2S0XAEHVhV6YudLBYNllYzINr" +
                                                              "g63QhuKx8CMN0HdVwNgF2JzHSAVg4a47HSBWTiYQm2xtNhUPhB9pgLI9AWOX" +
                                                              "YrNGAOGuax0gOicBiJoMEFtsbbYUD4QfaYCyGwPGNmFzGZT3TBff5/BZ8+B8" +
                                                              "6jwndg1wmvX/C2jSjJSJLx3wKeO8vA+pxMc/8gMT1eVzJy5/TbzwynygMz1G" +
                                                              "yodSqup+vu66LzNMOqRwMKeL538GFzzOSPPJP8BgZArLPBUPSYISOuuDKBkp" +
                                                              "xR83yQgjc31IQHVx454/Cph754Mo/Nc9D6grnHmwlLhxT9nOSAlMwVvTKGBQ" +
                                                              "8U4jHeJDC9yG4mjNPpl9XeeylpzHtfyrucxz85T4bm5QPjxxydqrj3/+bvEV" +
                                                              "gaxKO3fiKpUxMlV80MAXxWfvi3xXy6xV1r3kxIwHpy3OnPRqhcDOvlngODdh" +
                                                              "hIQMdK/5nlfsVmv2TfvrB1Y98bM9ZS+HSWgzCUmMzNyc//YnbaTgCLo5lv+a" +
                                                              "jpcZ4CxtS741fsGZQ395gz8HJ3lv1bzzB+WjB6985dZ5BxrDpLKHTIFDLE3z" +
                                                              "11JrxrX1VB4zB0iVYnWmQURYRZHUnHeAM3AnSLgtOS42nFXZXvwGBZw9//1n" +
                                                              "/pc7Faq+g5rtekpL4DJVMVLp9AjLeF5fpAzDQ+D02KbEtheb9jRaA/xxMNZr" +
                                                              "GJnXw5UzDR4G1majQ87bAnTc6/kt3n3t35wNHwBRKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e6zj2HmfZnZ2dmZfM7v2ejfrfe84yVrJUBQlSsxuUouS" +
       "KJKiREqkKIrdZM2XKL4pPsRH6tox2thoUNdo16mLOvtH67SNsbGNIkmLtim2" +
       "KJoHEgRI4D7SorFTtEhax4AXRdO0buqS0r1X996Ze6e7O60AHlE853zn+32v" +
       "8/Gcoze/Vbk3DCpV37Mz3faim1oa3TTt5s0o87XwJkk1GSkINbVrS2HIFc9e" +
       "U1746rU//s5nV9cvVi6LlfdJrutFUmR4bjjVQs/eaCpVubZ/2rc1J4wq1ylT" +
       "2khAHBk2QBlh9DJVeeBY16hygzpkAShYAAoWgC0LQGffquj0kObGTrfsIblR" +
       "uK78+coFqnLZV0r2osrzJ4n4UiA5B2SYLYKCwpXyN1+A2nZOg8pzR9h3mG8B" +
       "/Lkq8Ppf/7Hrf/+eyjWxcs1w2ZIdpWAiKgYRKw86miNrQdhRVU0VK4+4mqay" +
       "WmBItpFv+RYrj4aG7kpRHGhHQiofxr4WbMfcS+5BpcQWxErkBUfwloZmq4e/" +
       "7l3akl5g/cAe6w4hVj4vAN5vFIwFS0nRDrtcsgxXjSrPnu5xhPHGsGhQdL3P" +
       "0aKVdzTUJVcqHlQe3enOllwdYKPAcPWi6b1eXIwSVZ48k2gpa19SLEnXXosq" +
       "T5xux+yqilZXt4Iou0SVx04321IqtPTkKS0d08+3xq985sdd3L245VnVFLvk" +
       "/0rR6ZlTnabaUgs0V9F2HR/8MPXT0gd++dMXK5Wi8WOnGu/a/IM/9/ZHfuCZ" +
       "t35t1+aDt2lDy6amRK8pX5Qf/u2nui8h95RsXPG90CiVfwL51vyZg5qXU7/w" +
       "vA8cUSwrbx5WvjX9lcUnvqR982LlfqJyWfHs2Cns6BHFc3zD1oKB5mqBFGkq" +
       "UbmquWp3W09U7ivuKcPVdk/p5TLUIqJyyd4+uuxtfxciWhYkShHdV9wb7tI7" +
       "vPelaLW9T/1KpXJfcVUeLK7vqew+2++o8iqw8hwNkBTJNVwPYAKvxB8CmhvJ" +
       "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" +
       "PP8HbW2j2cdIPbC9547YeLgkX24ONQ7Y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aJxe+twDvUVkF7Yi2wnqnB263z2n7t+VxdeiykO6Fp3aadoL91/eaYnuONWz" +
       "ALYPALbvPsD/dE7dH5TFN3YAT21b7QH+/nsFWK7wv3IA8JW7D/Dtc+r+a1n8" +
       "UWFuBcBje2B7cN+6G9o76Lv7vrvg/vScuu+WxZ/stHdqQ20P8H+8V4Cl6/cO" +
       "APbuOsALV8+pe6AsLkWVBwqAJ3bnjuBduPe9wnuuuPADePjdh/fYOXWPl8X1" +
       "qPJo6X232erbo3zkbiiROkBJ3X2Uz59T92JZPLVT4ol9wz28p++GEzIH8Ji7" +
       "D+8Hz6kDyuL7d06424TEDjch9wBfeq8Anygu7gAgd/cBIufUvVwWjahyfwHw" +
       "+I7mHl3zbqATDtAJdx9d/5y6QVl8ZIfu+PboHl3nPaC7foju1QN0r959dJNz" +
       "6tiyoKLKlcjbb6b+0h7b6J1gS6PK5d3Z9PKg7RO3/PVl93cN5ctvXLvy+Buz" +
       "f7078nr4l4qrVOXKMrbt42fsjt1f9gNtaWyxXt0dbfK3AMSo8sKdj8xHlXuj" +
       "w5NxFxa7nj8aVZ46r2dUuVR+He/y0ajy+Bldyr3s7c3x9kpUuX66fcHK9vt4" +
       "u2VhXvt2BandzfEmRlS5p2hS3pq7M2cnt8J35xrTC9uqJ44b23aSf/ROejyW" +
       "qr944iTa9n9Ohyf34t0/nV5TvvIGOf7xt+Gf3R1VV2wpz0sqV6jKfbtT81ui" +
       "5em/58+kdkjrMv7Sdx7+6tUPHSb/D+8Y3hv+Md6evf258H65gFye5M7/4eO/" +
       "8MrffeP3tjvz/wdchicVgDYAAA==");
}
