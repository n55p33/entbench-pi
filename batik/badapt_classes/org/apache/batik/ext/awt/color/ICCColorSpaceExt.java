package org.apache.batik.ext.awt.color;
public class ICCColorSpaceExt extends java.awt.color.ICC_ColorSpace {
    public static final int PERCEPTUAL = 0;
    public static final int RELATIVE_COLORIMETRIC = 1;
    public static final int ABSOLUTE_COLORIMETRIC = 2;
    public static final int SATURATION = 3;
    public static final int AUTO = 4;
    static final java.awt.color.ColorSpace sRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    int intent;
    public ICCColorSpaceExt(java.awt.color.ICC_Profile p, int intent) { super(
                                                                          p);
                                                                        this.
                                                                          intent =
                                                                          intent;
                                                                        switch (intent) {
                                                                            case AUTO:
                                                                            case RELATIVE_COLORIMETRIC:
                                                                            case ABSOLUTE_COLORIMETRIC:
                                                                            case SATURATION:
                                                                            case PERCEPTUAL:
                                                                                break;
                                                                            default:
                                                                                throw new java.lang.IllegalArgumentException(
                                                                                  );
                                                                        }
                                                                        if (intent !=
                                                                              AUTO) {
                                                                            byte[] hdr =
                                                                              p.
                                                                              getData(
                                                                                java.awt.color.ICC_Profile.
                                                                                  icSigHead);
                                                                            hdr[java.awt.color.ICC_Profile.
                                                                                  icHdrRenderingIntent] =
                                                                              (byte)
                                                                                intent;
                                                                        }
    }
    public float[] intendedToRGB(float[] values) {
        switch (intent) {
            case ABSOLUTE_COLORIMETRIC:
                return absoluteColorimetricToRGB(
                         values);
            case PERCEPTUAL:
            case AUTO:
                return perceptualToRGB(
                         values);
            case RELATIVE_COLORIMETRIC:
                return relativeColorimetricToRGB(
                         values);
            case SATURATION:
                return saturationToRGB(
                         values);
            default:
                throw new java.lang.Error(
                  "invalid intent:" +
                  intent);
        }
    }
    public float[] perceptualToRGB(float[] values) {
        return toRGB(
                 values);
    }
    public float[] relativeColorimetricToRGB(float[] values) {
        float[] ciexyz =
          toCIEXYZ(
            values);
        return sRGB.
          fromCIEXYZ(
            ciexyz);
    }
    public float[] absoluteColorimetricToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public float[] saturationToRGB(float[] values) {
        return perceptualToRGB(
                 values);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SrgkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16f/Ds1nXXvq/tZ/vF9nu2m9hx49/PSewNT9L+0u64DdVq" +
       "pV1ppZW0Wml3BemLfu5q9XP1Y1faYppkpjhDmZBpnRKG1sMfKdCOkxSmGZiB" +
       "MmYY2mbSydBOKdCBps0wEAiBhIEWGmi50n5/v6+f80jCd0Z371f33Hs/59xz" +
       "zzm697zxjco9cVSphoGbL9wguWFmyY2V27yR5KEZ36CZJq9GsWngrhrHE/Du" +
       "pv7cL139w29/cnntoHJZqTyq+n6QqIkd+PHYjAN3YxpM5erJW8I1vTipXGNW" +
       "6kaF0sR2IcaOk5eZyjtOdU0q15kjCBCAAAEIUAkBwk6oQKcHTT/18KKH6ifx" +
       "uvIXK5eYyuVQL+AllWfPDhKqkeodDsOXHIAR7iv+lwFTZecsqjxzzPue51sY" +
       "/lQVeu2v/ei1v3dX5apSuWr7YgFHByASMIlSecAzPc2MYswwTEOpPOybpiGa" +
       "ka269q7ErVQeie2FryZpZB4LqXiZhmZUznkiuQf0grco1ZMgOmbPsk3XOPrv" +
       "HstVF4DXd53wuueQLN4DBq/YAFhkqbp51OVux/aNpPL0+R7HPF4fAgLQ9V7P" +
       "TJbB8VR3+yp4UXlkv3au6i8gMYlsfwFI7wlSMEtSeeItBy1kHaq6oy7Mm0nl" +
       "8fN0/L4JUN1fCqLoklTeeZ6sHAms0hPnVunU+nxj9EOf+DF/4B+UmA1Tdwv8" +
       "94FOT53rNDYtMzJ93dx3fOAl5mfUd/3Kxw8qFUD8znPEe5q//xe+9SMfeOrN" +
       "X9/T/OAFNJy2MvXkpv4Z7aHffA/+YueuAsZ9YRDbxeKf4bxUf/6w5eUsBDvv" +
       "XccjFo03jhrfHP/q/CO/aH79oHKFqlzWAzf1gB49rAdeaLtm1Dd9M1IT06Aq" +
       "95u+gZftVOVeUGds39y/5SwrNhOqcrdbvroclP8DEVlgiEJE94K67VvBUT1U" +
       "k2VZz8JKpXIveCoPgOe5yv6v/E0qGrQMPBNSddW3/QDio6DgP4ZMP9GAbJeQ" +
       "BrTegeIgjYAKQkG0gFSgB0vzsKHYmeo2gQBTQQRROI4XFRGQmERhfICuhf9f" +
       "ZskKXq9tL10Cy/Ce80bABYSDwDXM6Kb+WtolvvW5m186ON4Uh1JKKsXEN/YT" +
       "3ygnLg0omPhGOfGN8xNXLl0q5/uBAsB+ycGCOWDrA6P4wIvih+gPf/y5u4Cu" +
       "hdu7gbQLUuitbTN+Yiyo0iTqQGMrb356+1H5x+GDysFZI1uABq+uFN35wjQe" +
       "m8Dr5zfXReNeffVrf/j5n3klONlmZ6z24e6/tWexe587L94o0E0D2MOT4V96" +
       "Rv3CzV955fpB5W5gEoAZTFSgtsDCPHV+jjO7+OUji1jwcg9g2AoiT3WLpiMz" +
       "diVZRsH25E257g+V9YeBjN9RqPUPgucDh3pe/hatj4ZF+QN7PSkW7RwXpcX9" +
       "YTH8uX/15f9YL8V9ZJyvnnJ3opm8fMogFINdLbf+wyc6MIlME9D920/zP/2p" +
       "b7z650oFABTPXzTh9aLEgSEASwjE/BO/vv7XX/m9z/z2wYnSJMAjpppr69kx" +
       "k8X7ypXbMAlme+8JHqCzLthuhdZcl3wvMGzLVjXXLLT0f199AfnCf/7Etb0e" +
       "uODNkRp94O0HOHn/7m7lI1/60T96qhzmkl44tBOZnZDtreSjJyNjUaTmBY7s" +
       "o7/15F//NfXngL0FNi62d2Zptg5KGRyUnL8T+Key55kNeRNoX2ECwbgv3ibu" +
       "iWwPLNjm0FdArzzyFednv/bZvR8471jOEZsff+0v/+mNT7x2cMr7Pn+LAzzd" +
       "Z++BS017cL9ofwr+LoHnT4qnWKzixd4CP4IfuoFnjv1AGGaAnWdvB6ucgvwP" +
       "n3/lH/6dV17ds/HIWedDgNjqs7/zf37jxqd//4sX2Lq7QGBRIoRKhC+V5Y0C" +
       "UinyStn2w0XxdHzappwV7al47qb+yd/+5oPyN//xt8rZzgaEp7cQq4Z72TxU" +
       "FM8UrD523oAO1HgJ6Bpvjv78NffNb4MRFTCiDpxDzEXAjGdnNtwh9T33/u4/" +
       "+afv+vBv3lU5ICtX3EA1SLW0XZX7gdEw4yXwAFn4Z39kv2e294HiWslq5Rbm" +
       "93vt8fK/K7dXLbKI504s3+N/zLnax776P28RQmmwL9C2c/0V6I2ffQL/4NfL" +
       "/ieWs+j9VHarawOx70nf2i96/+Pgucv/7KByr1K5ph8G1rLqpoU9UkAwGR9F" +
       "2yD4PtN+NjDcR0EvH3uG95xX91PTnrfZJ2oG6gV1Ub9yzkw/Xki5Cp7nDy3Y" +
       "8+fNdOlY92tcQLpBgTh4YUaPfPVvfuaPPvpq+6CwE/dsCuhAKtdO6EZpEb//" +
       "pTc+9eQ7Xvv9nyzt6NHQw3L6Z8vyelG8r1zfu4rq+4GZjctPgQSwY/uqWyJu" +
       "JZUrPDHGCX4iYUzxprn3H0X5waJg9qqCvaVakWeZboHn+iHT1y9guqiwhd0v" +
       "KtPbIS6KcVGIR1DfOSYYbELJxE2cY7gxxRKTMYVfhHr2/4D6hUPUL9wG9UFR" +
       "uXmHqLGuyDHS5O1Rf/gOURcK9t5D1O+9DeoS2eLOUF8RsYk0BtLmRhdBXd4h" +
       "1EKo7zuE+r7bQL27qAR3BvVuTJpwF4EMv3OQxVMZgefFQ5Av3gKyUla2F2M7" +
       "uABWPO53jzz7u8959pM4+xzm7DvHXJryq+B56RDzS2+B+SMXY64cIb1cfIT7" +
       "yUUi/OjbwinHAEsI7ErtBnoDLv5/9c4W8LGVq18/ChNkM4qBP7m+ctEj4Z0y" +
       "f/tP+nMgW98xSGBzHzoZjAn8xcs/+e8++Rt/9fmvAINLHxncghrowiX5Iy/8" +
       "1/Ib85N3xs8TBT9i+bHHqHHClgGlaRyzVDsFug0UxQ2+C5aSh68PGjGFHf0x" +
       "sIpPtzpizTbVIOer7NIdcFsnCXlqkixI0V5JAkPMuI635T0BjdK1oPUVf1NF" +
       "aMUz+57sogS8aMr0GibHfRczqGFEBKPlUO1SZCitlwq11IPlsEvPhqqkh+pi" +
       "FI5JgpSx8XQTmRDKolmG9tU551YttNquolC0gQZjuCUQDuvvZCHDqgq3Gq+7" +
       "g1jSyYHYyxwun3cXq7g7l9F8IUKRj5g8RFou1RqnCo87qjXs2rDcovM6oJso" +
       "tO1RlC2tOQteLe0eF0kBv5bmxHrNOvOpKM0bge6JQ9rtqOHW3g7txRi2jTm9" +
       "bpFEqo762zFLuJMuLtCs4+EzA535Y1KkwUfKZJm2twJh6lHWzanJKN91aW0q" +
       "oiwuEU5r7nRzTpzPVM9g6L5UnRoESq+73mrY6+czBHG8WnepuLUp7i6MNb8K" +
       "kbwmJGybwAWZlJyW6/dIsueqRsAT9BodSaYnquy67dRFsk/IvTU2MaipOGFH" +
       "WMIuWAKJVJjrdkayJIoKPnT5wYRk14gkSDkuRHVCgIWxLpKh26VXI2HY05P6" +
       "2MlVJm4HeX3GOhuy1pkTnU41SyytS7nUbuwFjjJekYREUETTZhcSGVKOggR5" +
       "bIYQkUlrC1MWnclsTDuqYiIwNO2PhgSlLIc1vgZPZ0S2lvt6W5M3XT6gU9Ol" +
       "YHlSW9VXy92QSzeOTyoe1jXITtrSFwiqj2EporsYO0B0jKnuJCqsi0Sk02za" +
       "7ncdo9ZqEBiBJSLS3UlxbTt058QU7yF1QnYExaF6AR8Nxyw2XQ9xrBp4qp4x" +
       "ZL+W4CbFzed0HxbZjk7xbVLqjeYNBSNpFjBPZWLUZVZK09DTHW9bTabj1lYa" +
       "2WtnmJ5nLScIoFxejCaxMF7bDUT0CUzXYzVY6VG6rdL9juVQmEkTA4/l241k" +
       "PXFbnYTfzKUl4qlYbb5IwtpQcYV2n95A0MhbdoKUkagsn0wkpz7IZ017N+yu" +
       "4bovOiM23tk9Qm73JRviexqcjcwND++sdpMbsrgjyxNPwXrVNdGZEnTsSjO4" +
       "La8XsbeaWzQPdp9QzToePenyOBW6wza3otoaguWTeegkrhrF2q435oCMCWSG" +
       "zUimj1hjnWhn9MjphEsay01iIfN4jYDQnkUHDkl3JKInrO2AsIf95U6SjYmF" +
       "E0zfnpMJ3WCzNh8YgjQatVIc6O3UwrFo0W3ykhn0x0Mp1wS5O0Tm/FLCbcKp" +
       "EVgwqc21uDdL8CohbkNkNukl7TZR8zlkhK0oTHN7LjearhqbpmO0Ibra4nkd" +
       "s3oBg8dKl3YGHM5ijW0mNn2MY7F5F81ZW4cGVRwhMMuebhtashjhgzq5kfko" +
       "cxuo2mGk2ULthDArLwCeRB+JS6fZMGApqA7H1TQyWkijge4GkCo0hDQgYWk7" +
       "ZENVYnwYd8JpY9uI/PVyKdFoQjEDXcLVLE3tSOQ4MbDYGfDPw3TiEgYC13KY" +
       "IJYzndpOKb6Jw0uuqnsZ1mHrK7JZj0KoUZ9J3amiYKLDw4K+8zx1ZzRjeJCa" +
       "qyna86uwMdCMVlJTfEz2/HFnxwLFktftQUogE2QST/FGmxwgjpHFu+puR9WH" +
       "cwwoPx0bPrNtyg0uGdGDgRR2G7OBPIGXOb9YayY71BF6FlZhubkOEY1pCPUh" +
       "JVJ1IuT7aQL3RahtInZP1906Mxvvdpka43TW0ro1JKuaJmQwu9EuNF3wXYSJ" +
       "/bXhh3mfpCK66a53kaZJBiwuBmlH4Hp1FEoyGh3t+no3WEmz7W6uC00cnWOb" +
       "7q6ndwxrGmloM2vjUwg1dY/kSac3WC9lQqFnuC53FYHQ1klsij1WYRdCqycn" +
       "XjbZTmquTnhUnum9VtLXXFOAOnOknXS2rCIndJoMlBq20VpTo+5UPbNmJTs2" +
       "55dExPZru+l26yeLWY0WUYOsz+3Z0NF8e9kSDB73ja49x2GNsNEhm8KWN+/x" +
       "Ha6NScF6W5+4Dr5sDGpKYuwizOkmXLbYUjPR6XI72UW02a6LmrTZifv1KoG0" +
       "Wlsd72YprNW7HmxYNasRtxujfIK1GiuXljiYspxg1cOnmybkb/v8rtmAApZH" +
       "F3Ha5kNhgA6HCE+zrjGESWJlztZ4YuCxUCfrUDNooKsONCCt7lQX2tu6toG4" +
       "ZhuYzrrvtRPNN9RYizl624mNaNHgfHFl2A6t9wltU2+gKZRMOylkbNdmZCy1" +
       "eFBNGNTaQBtlyw7qftAaN+HAWWe1jsDAHSdLZ9WV2W+hAmlU06olJR1p2nFI" +
       "DQ97eSiSuq9OVmmI2YYX9lluojHaejBfuCwCfG7AZbVtt5Y1B2N+Vae22yXm" +
       "9mpMOuKGW9gf+fJGnnLKaruubxix25muBjtgZdd+hKaqkatjHmbspFXvzpea" +
       "YjbWSBW44BWRYik3UsDXNtJGu2NhgHFDyh3X5jA+6IdZHo4bTLqexCu007T4" +
       "fq3ZSKlN05DyYSCgmTwnbWtHDRBxnjFDA47QViq1TTifbZEeI+Oyknt6MseE" +
       "Td6ENRMEMLlKN5H2iLF8lA4Upz7tRhOOqrk9ps1y23BWmyq+ECX5YIBmed62" +
       "qgmawJ1cxhdiv9uCls6WaBopr0HAu3JiKnFThlzs2lN+QPvzqp13Mrs60wgh" +
       "zWtyHRhJRDOy3a6qV0c9S9qEGp87GoVObUOYa6QpOEhAZNxAn7fmrOKPRjra" +
       "QXx81Ngatfm6nfjmfDDddgxlqGy3kpc3oaSdrLAauuz7SzXSo3HLrvERZq0G" +
       "gWR3dXqr0OuFualr/C5qtAUEZTb0yrJbipAMusNIqs0GbXFVjyzOpzWpOgPs" +
       "ocxo1RxV7ahvrSSNq2ONJerihNToSaMGa3gBiC8QmpiOeU9ORIG0JzK2q/Uo" +
       "udV19JohydummLbBIjZooalxzKC6oRvVVqSxSwuHp/pO1d1Fn0biTDBJYrgW" +
       "pj2b4trjXavZZ7tLNF/6zmomDmyYzgLVxragX9IaBxoeyPlam7RHiKyoFqlP" +
       "JbbGE1ANlvXNAHMnUWvZMO3+VvVkGJk3WutgUt3EGzsdrjGVgKoqeJsMtpvt" +
       "Nu2njoT04n67B2k+nM5UrrruJbK7YeWlJYTZwq/vQHhkDTMQE2ZISx0v5Fyt" +
       "85PmSPV7yKzZqNlwDZU9leipTU7TcSjKcySbL/CI0oRqisJQ3Z4qzSo8aW7N" +
       "5UTrQI483zHSdjRa5gY+HqMEqttJn+cCicwxMh/3N1FX2CG1uQ6imp2FSipw" +
       "w4qR5r47sFNmvIsHg6kKrJbogkAdSL3TrUE6n7FWysftTUeyDWUjzNSVyk2G" +
       "RhANe+SoMR2h7tBaVlER5aNmdbPToDrDdGIvTY1cZE2k6Xpcw1rVWXs5GVge" +
       "ig/bwaSDNjptdZwDlndmv73RsxUtQrQPCYY5izrDDTnl0bjRpKROq82MV8Yk" +
       "ZFJd5lbTSZrS6dwFPgsNsE4tbvJ9Mpq1R+YKFTpZlRU9ZeTw7pgXa7t6sw03" +
       "dw4aj1ig5mq89usrtsqT1qA6TmbD1sQzrX7baPaaJh3ZomWKs80kGztKH+k7" +
       "itEiFGW4geZQfU7hU5wZsjAm7ZJ4Ew7R+W48XveAIlSV+mSuVVUTSc3Uq/kd" +
       "trqp57nUq3dTm9KNJNry/iIfbTYbAzcMvsNQ+ZCV7XlStze5Ntps5dqs1t61" +
       "RpNVe9U3x3a9FzT5ETOw2BQdrRYaTSJmzEJIy8wtSnUlCZ3lIc6T0qqDKWir" +
       "P+lQix0t05uFjHJSgx/ulA4IZbvYJvZXgrPeRqTdiGCu3qoPh153R+qUSbsa" +
       "7KeNkMqVwvHz2Iyz9fbU5HW951R7iCRKdisZY8CxAGc2Y4IsWLmcmlcptlVb" +
       "dG0bWumjhYOoeZD13faYkm17HvM1b+aGKCdv46Ev5A171CJQodZHatMh2abV" +
       "ptJatteMsyNJbijNatGCGJgZiEc4ehyRGK1s0fUkz8cQ57LedhajauqSzVpL" +
       "tIb2zjPHBKZw7VV7lKk0Ag8XSSPXedHDBEUILWLGKs0OvFWB3sMyp6T+IA/i" +
       "zPedLdOvjsVBr000BGASmqrQXNeJKhfy3VFfDrmeXG9Uxz1flxqbiGlnm8Fo" +
       "2yb47XSy6CDZtDMYzjPSgiHwTZbbIlJfdCizN5AdfkZ6fsclzaq1Fl2LjfiQ" +
       "lBsajHTwdaurDAhoGG/4ddYjNshMaDErcidv+gxJIeHUM8VmTIPQokc3alWp" +
       "jlhMPFbVECcs1/GG88EYF6pViO3qsMAywbK/Jab1xXIxgVB0Po6AZ1z3BB1x" +
       "papOsWmXC3oL8Ak3ZcJwxIHQRNM53+KaEwGE7GS7Vts1Wr3xOo3oGgP5dDcl" +
       "m3y7nnF2I+krK6s+85ndVts0wzHwyDMtFUR7CjPQNpLU+XLW7M+mYThtzbWa" +
       "BLGWx+h5fbqb6vNBkpL+GueDsY1hI1/djNudOq6ySXvjr5AGPuUhr7lpCRsh" +
       "8mCPX/RbDltXkHoQMoLjB3ptjNJJ0uLQebc54zpLKN30d0mVTzehCfEWh0aS" +
       "3WnLg10I0/OZVoMbNW7ru1NSxNZ67nlMfSVbsUypATec8oJG1MF34YJy8a4b" +
       "G4g2aVgNuIdZSLIwogE7VRAlEzoo7fk05A0FaOLBgqv6axAk06HUcIK+F3do" +
       "E5gBJVqNRhL4gsZ5dRhkfJKpxA7EOt3d0ht1+q5aDUbDtuiNwjmPpEa87HAU" +
       "U+uO/RbUYGJGmorRwsEwrLzp+Rt3dozzcHksdZx2snLRouGv3MFJzb7p2aJ4" +
       "4fjYrvy7XDmXqnDq2O7U3UyluD168q2yScpLss987LXXDe7nkYPD87xOUrk/" +
       "CcI/45ob0z01VJE59dJbX/OwZTLNyV3Lr33sPz0x+eDyw3dwMf/0OZznh/wF" +
       "9o0v9t+r/9RB5a7jm5db0nzOdnr57H3LlchM0sifnLl1efJYso8WEnsGPNSh" +
       "ZKnzB6Ina3eLFpQXEu/fr/25K8NLx+kNL7y1AMur3v2N6ut/6/kv//jrz/9B" +
       "ea13nx3LagS+oC/ICzrV55tvfOXrv/Xgk58rMwru1tR4z+H5hKpb86XOpEGV" +
       "8B84FsgTBf9Pnz96TyrT7zJfBXTzoPIIGwO1Ui+OUmG+X0NnF52c3mO5gZrc" +
       "sk7H56NfODoB/0e3ObV//5lNf9k1/cU+s6g8C//lw0uEYvxzt/WPnpwk427g" +
       "m0XKwFHbPmXGDm4cJ9eBxuxCpL+wR1pOdspeXKSIp++uv3ibti8Vxa8C+egF" +
       "rj0btyH/crb//bu3ofnnRfFGUnmwvCswTGMSjPvdE9ClLfzs251anx51z/zZ" +
       "zVuYwg8d6uqHvqebt0RaEvzubbj8N0XxL5LK1dAE6hkmqepexOfvfLd8Fgkt" +
       "5iGf5veJz39/Gz6/VhR/kFTeHZmuWuRc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("lDvOBqYksvWLOP7q94Jj/5Bj//vE8X+7Dcf/vSi+AThWtThw0+RtOf4v3wtd" +
       "3hxyvPk+cfwnb83xpXK+/wV0OS6SeUtLehGff3wnfGZJ5dr5LMEi5enxW9KS" +
       "96m0+udev3rfY69L/3Lv1o7SXe9nKvdZqeueTqU4Vb8cRqZllwzev0+sCEuO" +
       "7k0qT90+hbEwecVvAfzS5X2vK0nl8bfqlVTuAuVp6geB7b6IGlCC8jTlNSCL" +
       "85Rg/vL3NN2jSeXKCR3wMPvKaZJ3gdEBSVF9LDxyIU9ekAx2Ivjs0tkw8Xg9" +
       "H3m79TwVWT5/JpwpM9CPYrd0n4N+U//86/Tox77V+vl9yqDuqrtdMcp9IPLY" +
       "Zy8ex3/PvuVoR2NdHrz47Yd+6f4XjmLVh/aATzbDKWxPX5yfR3hhUmbU7f7B" +
       "Y7/8Q3/79d8rU2D+L/HszR8aMAAA");
}
