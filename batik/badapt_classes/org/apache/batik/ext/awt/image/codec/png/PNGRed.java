package org.apache.batik.ext.awt.image.codec.png;
public class PNGRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static class PNGChunk {
        int length;
        int type;
        byte[] data;
        int crc;
        java.lang.String typeString;
        public PNGChunk(int length, int type, byte[] data, int crc) { super(
                                                                        );
                                                                      this.
                                                                        length =
                                                                        length;
                                                                      this.
                                                                        type =
                                                                        type;
                                                                      this.
                                                                        data =
                                                                        data;
                                                                      this.
                                                                        crc =
                                                                        crc;
                                                                      typeString =
                                                                        "";
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             24);
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             16 &
                                                                             255);
                                                                      typeString +=
                                                                        (char)
                                                                          (type >>
                                                                             8 &
                                                                             255);
                                                                      typeString +=
                                                                        (char)
                                                                          (type &
                                                                             255);
        }
        public int getLength() { return length;
        }
        public int getType() { return type;
        }
        public java.lang.String getTypeString() {
            return typeString;
        }
        public byte[] getData() { return data;
        }
        public byte getByte(int offset) {
            return data[offset];
        }
        public int getInt1(int offset) { return data[offset] &
                                           255;
        }
        public int getInt2(int offset) { return (data[offset] &
                                                   255) <<
                                           8 |
                                           data[offset +
                                                  1] &
                                           255;
        }
        public int getInt4(int offset) { return (data[offset] &
                                                   255) <<
                                           24 |
                                           (data[offset +
                                                   1] &
                                              255) <<
                                           16 |
                                           (data[offset +
                                                   2] &
                                              255) <<
                                           8 |
                                           data[offset +
                                                  3] &
                                           255;
        }
        public java.lang.String getString4(int offset) {
            java.lang.String s =
              new java.lang.String(
              );
            s +=
              (char)
                data[offset];
            s +=
              (char)
                data[offset +
                       1];
            s +=
              (char)
                data[offset +
                       2];
            s +=
              (char)
                data[offset +
                       3];
            return s;
        }
        public boolean isType(java.lang.String typeName) {
            return typeString.
              equals(
                typeName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL17e6zk1nkf7660u1o9diXZkqJYD1ur1PYEyxnOu7JSkzOc" +
           "F8kZDofkzLBx1nyTQw7J4WP4SFU7AhobFeAYiZw4QKJ/6vQRKHaQB9KiTaoi" +
           "SJPUQQoHQdIHEqdpgSR13dgokhZxW/eQc++de+/uXlmVnAvwzCHPd875ft/5" +
           "zu98PDz39a9C9wY+VPJcO9VtN7ypJuHNlV2/GaaeGtwckXVa9ANV6dhiELDg" +
           "2S35fT977S+/8Wnj+gXokgA9KjqOG4qh6ToBowauvVUVErq2f4rb6joIoevk" +
           "StyKcBSaNkyaQfgCCd1/omoI3SCPVICBCjBQAS5UgNG9FKj0oOpE605eQ3TC" +
           "YAP9XeiAhC55cq5eCL33dCOe6Ivrw2boAgFo4Up+zwNQReXEh549xr7DfBvg" +
           "z5TgV3/s+67/3EXomgBdM51Zro4MlAhBJwL0wFpdS6ofoIqiKgL0sKOqykz1" +
           "TdE2s0JvAXokMHVHDCNfPTZS/jDyVL/oc2+5B+Qcmx/Joesfw9NM1VaO7u7V" +
           "bFEHWB/bY90h7OXPAcCrJlDM10RZPapyj2U6Sgg9c7bGMcYbBBAAVS+v1dBw" +
           "j7u6xxHBA+iR3djZoqPDs9A3HR2I3utGoJcQevKujea29kTZEnX1Vgg9cVaO" +
           "3hUBqfsKQ+RVQujdZ8WKlsAoPXlmlE6Mz1fHH/rU9zsD50Khs6LKdq7/FVDp" +
           "6TOVGFVTfdWR1V3FBz5I/qj42C9/8gIEAeF3nxHeyfzS3/n6h7/76Td+Yyfz" +
           "nXeQmUgrVQ5vyZ+THvrSezofaF/M1bjiuYGZD/4p5IX704clLyQemHmPHbeY" +
           "F948KnyD+dfLj/+0+pUL0NUhdEl27WgN/Ohh2V17pq36fdVRfTFUlSF0n+oo" +
           "naJ8CF0GedJ01N3TiaYFajiE7rGLR5fc4h6YSANN5Ca6DPKmo7lHeU8MjSKf" +
           "eBAE3Q8u6Dq4Pgzt/orfEJJgw12rsCiLjum4MO27Of4AVp1QArY1YAl4vQUH" +
           "buQDF4RdX4dF4AeGeliQz0wxDmFzDYYfll0wYLAHXIse9xlVuZn7mvfX0kuS" +
           "Y70eHxyAYXjPWRKwwfwZuLai+rfkVyMM//rnb33xwvGkOLRSCLVAxzd3Hd8s" +
           "Oi4IFHR8s+j4ZtHxTdDxzV3HN8BPx4gcCzo4KDp+V67JbuzByFmAAwA7PvCB" +
           "2UdGH/3k+y4Cp/Pie4DZc1H47iTd2bPGsOBGGbgu9MZn4x/gP1a+AF04zba5" +
           "9uDR1bw6nXPkMRfeODvL7tTutU/86V9+4Udfcvfz7RR9H9LA7TXzafy+s3b2" +
           "XVlVADHum//gs+Iv3vrll25cgO4B3AD4MBSB/wKqefpsH6em8wtH1JhjuRcA" +
           "1lx/Ldp50RGfXQ0N3433TwoHeKjIPwxsfC3378fBNTh0+OI3L33Uy9N37Rwm" +
           "H7QzKArqfXHm/eS/++0/qxbmPmLpayfWvZkavnCCGfLGrhUc8PDeB1hfVYHc" +
           "H3yW/pHPfPUTf7twACDx3J06vJGnHcAIYAiBmf/eb2z+/Zf/8HO/e2HvNCFY" +
           "GiPJNuXkGOSVHNND54AEvX3XXh/ALDaYd7nX3OCctauYmilKtpp76f++9nzl" +
           "F//bp67v/MAGT47c6LvfvIH98+/AoI9/8fv+59NFMwdyvrLtbbYX29Hlo/uW" +
           "Ud8X01yP5Ad+56kf/3XxJwHxArILzEwt+Ouewgb3gEofOCe68c01GI3t4YoA" +
           "v/TIl62f+NOf2bH92eXjjLD6yVf//jdvfurVCyfW2OduW+ZO1tmts4UbPbgb" +
           "kW+CvwNw/d/8ykcif7Dj2Uc6h2T/7DHbe14C4Lz3PLWKLnp/8oWX/vk/fukT" +
           "OxiPnF5icBBB/czv/Z/fuvnZP/rNOzDaRRA+5DdV0NPzdzdcYf2dHV77h8/9" +
           "9sdee+4/gcYE6IoZgOAK9fU7rNkn6nzt9S9/5XcefOrzxSS/RxKDQoGrZ4Od" +
           "22OZUyFKYckHjn37PbnhngV+/y92rr37DSH5ba4lkm8qYBHBgJYz2Te9EIRA" +
           "uLM1fddZgzaOlqy/jm52E7mcJ7VdvhEC+6XhzkA3c9THC8Y5ft/Lrbzn3Cf+" +
           "amJLL//x/yr84bal4g5T4Ux9AX79J57sfM9Xivp7zs5rP53cvroCD9nXRX56" +
           "/RcX3nfp1y5AlwXounwY2/OiHeVMKAAfCI4CfhD/nyo/HZvuArEXjtek95yd" +
           "iye6Pbta7OcAyOfShTvuFog8eTE5gAp+HBY13lukN/LkbxTmvpBn3x+CRk1H" +
           "tIt6NcC+turou5iqmicf8pLjYbqwq1fcvzs8JLYcBwhtXUfNOfKobBcjmO7N" +
           "49cKUJjcYcA/ePcBp4pps7f6r7/8X59kv8f46FsIDp45M4pnm/wn1Ou/2f8u" +
           "+YcvQBePx+C2d47TlV44bfmrvgpekhz2lP2f2tm/sN/O+HnyfGHi4v6Dx5aA" +
           "CktAhaxwTtn35skcjJacm3o3MueI30qKBbJa3MDnCIp58kxwMo46PRAnXmZv" +
           "yZ/+3a89yH/tV75+26Q7HTZQovfC3hGfzVeAx88GjQMxMIBc7Y3x91633/hG" +
           "wcT3izKgmWDigxg2ORVkHErfe/k//KtffeyjX7oIXehBV21XVHpiEa9B94FA" +
           "SQ0MEP4m3t86DP/jK4evA1AC3QZ+54xPFHdXinz3dMTxKLjQw4gDPRtWHU6t" +
           "1Z2nFnS32XS9kJTyxNopoN5V2TPq5BnsUB3sLups3kSdY5o4q4z/FpV5F7g6" +
           "h8p07qJM8mbKKGJYeN+HziiTvkVl8qLuoTLduyjzsTdR5qLsy3cyzMffoi5P" +
           "gqt3qEvvLrr84JvoUvDYbtfiiE6v76l2V3BGzU+8qZq75fcAxNf3IjebN4vl" +
           "+IfurMjFw4XhUlDsGuV35JFuj69s+cZRlMerfgAm/42V3cyLXzmjVO1bVgrw" +
           "w0N7hKTr6C+88l8+/Vs/9NyXAS2MoHu3+coJCOGEGcZRvoP1g69/5qn7X/2j" +
           "V4oXCLCg8B9//s+L2fZj50HLkx85BevJHNasiHJIMQipIuYHr74A2R2jF8DB" +
           "Z4fgW0cbPswOasEQPfojK2JngcoJswgXAjInJ9vYnGcjA2HRJHR6BhXYNaQ7" +
           "wj0xC+3pnDe4lPEaisTZq0yuUVSzOkuDKeagtOO6eiLU8M1G0RN3mq5nHaNj" +
           "yJSH63SPk+cMTqBxvaPrMp9hDDd0ZzhZatabymQhOAm/NPku194q1XYEt2EY" +
           "1uBtNSzXsakXlLMZ2+XmS4bqhzNC6UcRzw6D9cRmR4HZGITWoB4apKc3tirS" +
           "HK5Zyh2kRMykihvMEinkNqYYoMLQaowEdjyyxDVijIc4t52JlU3XWlPcYoEF" +
           "hpyo3qS/cU0CSTNng9bcXitdNhh1GSRczbT7Uak86vfXBDpTmMyyy1up1CQ5" +
           "YZ36blKbJloN89Wa6mMWZzvkMmKiUI9ELiU8zzSZ9YRIFH82WjmD8ng+WvK8" +
           "gwve2uKrG4xd4mtkuKjjnbg5HIjdrFQXxdlkmmFSeTVTZK0f+Ao7q7B90Rz1" +
           "RK/Jsx7n+OJ2xHPGcFURm9iKZPuUG/aXCu6Sow1TMaxedaxMSWERlEmrRnbH" +
           "bDTDV9NaHLS5ujkjRC4kNK/OZt3uaEHZXpnVmwwZhEOCWIzx7WQuN4YDyd94" +
           "zWDIcl0PExk17CprRtcD3ERj1GVlEI6LFXrUN0x9zPjuJC6J5ma2iVJkrFR0" +
           "Qp6ISY/QYT0OkJGebihnoZBoh16OAsHy1pFn8VJNl2wa8SXc5A1rMFeXjWAa" +
           "DCMJlbFNwugZls7iST2wwhHDcEEchAZtCfOkLQcxiuu+5c3GjfHanq24Ud8y" +
           "uxTW48uuuNLmWANZoRSp0BiKV/p9nXIYMR7PmAZvRJY+3zDbBQG7uo1nEwwb" +
           "xmD84Qwt4YjplUXZtqv1icTbzVq2EBmzQk0DLNMDd9OyW2OGKpfcTaVsjlyu" +
           "7eK6Q1qpsgnKzWavveRGequXacvuYF0TS/LWYfhWs+8kgtlTZamcDBRmPa0S" +
           "WGmSLeyMC+ajcUcaMaJqzvXAr86oenUuwkq5vkRiiqbSVmPoCD2q3uyHSaNU" +
           "a9r1BmWlm8ha130i8kZjg9mKsQOmh11f85zbkHCRIKSMwETXpatKnSI2lMyt" +
           "lv7c2eCG2RxF3MZPPYdQ4FgcGmuUMAidaLgu4vW1jREwfbVbCXGc2NRmvUqr" +
           "lxAJ1oaphKBXkTHqe7w146kyrXh+wzTh3nRO47ESMI1REtA+syHmDtvtYpt+" +
           "bcKk81hPehul1J3YlCDw+LpT2lCp2qHqoot57XmjLnXCMTPuzldU27ZZlpg4" +
           "QauHDiskPWyizALJyoLC8ljGdRtTMWq1NA3WgxaJyj16SXR7KTWLZXwaDkoU" +
           "KQsy2cGlemx0WrK+BJCj3lwdzCmPZBjgKomhyvqoTFZd0mZa6EA3+mrUGEeJ" +
           "qKolYcbrCiXUCLkzmdaVum73B7VUT6tOZUqH3jSobj1T4WnDsr1VlxlSwCGJ" +
           "QJy31WWsdir1yri5pErU1PMSN5CnPMl2qbXkUXipE+gbok9zkQ0cdyz1FWu1" +
           "jvpsJ+sumGC8Mpl6aaYNJKMEb7fgXbhFWU20PI36U6HUXVrN8rzqOAvNXzQH" +
           "Vh9WEWOrluCu6y/CclLma0OrtuYmwtTVMxImJMNAlOnCt3F1vYoDFgkH9FKo" +
           "UYSA9YLJtj/JtBihMcQn1cGE85ghPgjJsUcwJh9LK2IlmI1oPOk0NUG1GxqK" +
           "CMD1w5RexVKTrRLVtt7MWli69bEk7E60XjcRF+ORU6WRZg9utphpvTryu1y0" +
           "Ijp04IsLqkaNkK0ubbYqpWxJlvOM6iiqttv1VtqwpNCZSAaDhyVGCBJp2HUw" +
           "08X73VISjhdbWJqby8nWwMpNIemOuWpvaIYjYTgLGc+2esaQ5TOHraFz1dU3" +
           "IbpBHMVze23CmhC9nuxJmwSuzOoarGCa1IhZZYN1Zi2R4q1yW1fGJWYV1Zvh" +
           "2odDh/JiZ9Qfxko2Sow4oGllLahS3Z9hNMFstw0w4JFqRY3+HB2UEH6EcKV6" +
           "Osusvqc02qtt5JHJvLrstTYzvttdY0g7i7YKobb9poawJp449Q4+rZUkFYcr" +
           "KtyImk40JvxgpqxKZVepVfxFbTKQe/bSmXZhDtbJWKM0DcPKEoYxLjHodi2e" +
           "DPzBkBqTaGnpdlJxvNAnpmr4Sr9Z9be02UfpitTEwnEbazbbosr20fIoG256" +
           "XipbXrU7NTfMwFySeD/iQ1HE+ElZW0RlFoGjvkZ3l4SPrdu1pssGrWYTLLxR" +
           "PZ1UtnSdcvre1FXsUYP2vLTiDOiW6vU7JGvMm3O6GjLTss6V3HrIeSvWbhhs" +
           "yPqGYwwyahbwSuoMZyOlqff0Mh+XDXek6mg/bSKOjaS9AB9zRAIL2iIZNWJt" +
           "q010C/jUVlun3iKY8C1vOxq2M7VFVcjAi8o47+JWiFYsrQcDymMiFqaW0oCd" +
           "cVgsBQpLCvTYmHenqi9slmXP29RsCzAvr+kt2xpIc6YeILO6PKrCcisgKlaK" +
           "wBhoYTiaE9gUZ9u2qHbHQq8FN5iw3Cjx43GZrrU0TzJ60rLS5GBYzsYNNhhM" +
           "wkqfSGbsiu4gSJZUVGkD12zMDSlq4lZ5LRPWcn0VD4PWeirD1czHmu3GgoT9" +
           "cU2FtYlZozZyF2m3gd+TxmClwu24rLQGpQVeWsVqzMkw3q2kPEIPIm8iV/V1" +
           "YzZGxCyoulO0NWkunOpo22IWtlRqZB0wGFglcBC1OdK43lBMUa4rpkac1uTM" +
           "a2iqapTZtFoXxoQh1RfCyJ8vSjWlBJe5SBIqGt8x00EHbae8MxkGi00Tr+mh" +
           "TCH9gDEMarM2Z2nkzKe0wW3YZdDaGpU5PV2uLKmru014EXSDdMik8aBHVFK9" +
           "H3GpluIBTwvDdmqNHDoM3Va46gvrBt0NsW0W+nBSVkSjHZEzzkz8xZqwsTFM" +
           "xsvQj2NknLV8tlRtz0q03SgLSM/rSeRWEqwBTDhIXGoFiS20/GYMp2WyE+v1" +
           "OhuO5n7W8KuE10lsEXBW1STKWZNz+CHcm4A4E6bV+pwtT31dMyyS62hKOmGC" +
           "3lzozcrBMOjEDUTmg8TqRRptsRsWi8ZCpja0DIYFJJiwo6reEBrMSNvCnVpC" +
           "bcl0hcbT6TxNK1UtgvlgEqpir1NqCIuqCPtgeUrKKxNOPH8ijUR6jPBtx7Un" +
           "WjNrw5IwC3DGqMI+HvJt0UuypiH5iWgFA2e+Kq8HqMY6EbsY2JV5S3O3Tj2t" +
           "tlrcDI9qJi+60UhyLc2t6VTaAYvncuh0WDbxtMCCmZq3QNKR2aCogHSGbmu8" +
           "hJfRItCltGq2q/XAyGqCsxXKhg/LgNcTuuUvWo7L1qyoSqD2uE5TWa/mmFh9" +
           "Xgu2Zg1EyJS7WcKO6qzE5nIhotVVaeVTva3nkIKBVuRKunFazrYXWBa/8gOB" +
           "dTvrcaJZlKWLazQdsvio0S6XRutWZFlOgKzRbZD20ZQNCMqw8e58HUqUX9fJ" +
           "NJthNammrlO+ZBE1Gh9gC4ty11JHrW2llIuHmyrdWYPJEWhwF41Sp4W0OHpU" +
           "F2HaXyBsr4VWOKaaIYKZOYvEXLiyt+n4K7JeUmm9qk9YU6h3N9nYa2/msTeo" +
           "dptUwibqtgs4IW7CVFkbbcdxtoS3QxDqeivL2TS6MzSoNZYy2e4inWQ5oTLM" +
           "XJOTZa2LaiWnXLdpAe4RJamLytWgY0dLogYIemmWdSKFiRCrDoaB0ycsdNAd" +
           "GVV30QnmNrpkmkgod7I4EWwGxl1shM8tmu2hTnm7hHF5mHFIJ2j06Qmjt7Sk" +
           "DGJ5fIVMyRE2pxkG89CFTfcmRrNf2y4MnA9S0oCx2mLhxXhPo4yOSuhhxyyr" +
           "xgybOY1ZtMDbljqTyekAJ8yqjPcmFUBLc207rXHNcsMxK1igCqzpTnXTmW6I" +
           "VeyhLRafD2LdjVZzBIlkB141FK7DhKpA9qZJD5/oHOdKI53Ah/x8hAa9iVJ3" +
           "p2bPMyiiXJcGJNYghmPCc/u6i1KcTPY3KTfKtjpCzpWBQ400jELoEdVD26Ax" +
           "m+M6cYRS/IzEXKMcUy5Dr3Sxu0qGTSbuh110lQYtLUorjOJJNOZhHtVzB5Ph" +
           "zE83KKPPyCBFqzyRBZUG3mlXy7zMVxYbkbXnrbTUiqips63Cerc7nvUX60kK" +
           "fL9l10JKpz0BdcjWqp7EWZLFbAoLk4qtUU7YLG98K8gGcOIk1srmcI+vSsrG" +
           "dzb1pTI0jHnoe77erfU02+WC5USLspYuDIbcRCbLIx9jeaveQDSD8baLbTf0" +
           "oorukVZM8t0krEcbs473pjyLDupsVFYQKqOsat8SOg2mJujxhNXSWQCoIpJZ" +
           "JEbrlWQ57Jg1o5H25uJgyK9CKhv2a93N2OS2LFCnSi6mEh63K3JDTaeKImwC" +
           "Ppu0WLg2UzK+Ls9geAheBUpKlWTtdUgtBsZIm8x5HgmQxQa83Ha2A8zmSkS7" +
           "WiFRRCOz3rwky5wTJI1lwCbZZBMsut2gtCRw3xvCGLai49omY9qxMxWDSqmz" +
           "yMLa2B847fYCtomlQYqsRbHD5gSpV1qhN4wXgyRCkuqkPYQFcrQtI+Blz8iW" +
           "IbJxpVI7VmF1RjUq2wXccumMqDHlbbPSjoOuTW38LZaRYHHWxs1mDKIVe7lZ" +
           "1a2uh4vJJKTRYZCC91jfGba5oDqYzkrrzsSMKw4rLfltHc8CM6uWKlmkJQK3" +
           "AcQ5VrYVeySh4twzvbHn4YKfLIT1ukuNBzWSXW4CJtXhDrpBkThpDZZCQA81" +
           "siFTczvm23OhmiBmbdpMiFDsw3FQ5VoG1+3oKIq++GK+vfIP3tq2z8PFbtbx" +
           "kaL/j32su2xyHhR97T9hF/t7V6EzB1NO7A2e2IyG8u3yp+52dqj4WPq5l199" +
           "TZn8VOXC4aZhM4QuHR7p2rdztcizxzrk+9nF90buUAfu7P7kHvedAb1/Z7dz" +
           "vib80jll/yxPfi6E7tPVkNxvi+/t/PNvtoN2ssU7gcs3X5eH4JbvPLhfPafs" +
           "1/LkV0LoMgB39C3oBLR/+TagPZY/fA5cHzmE9pF3Htq/PafsS3nyb0LowUNo" +
           "+w3oV/YAv/h2AT4FLvEQoPjOA/yP55T9QZ783m7sukffJPbQfv9tQMu/k0Df" +
           "CS71EJr6zkA72AvsPvH9yTn4/ixP/niHD0vDwjc/vMf3n9+JaWce4jO/Tfj+" +
           "xzn4/iJP/vsO39AJK2fm3p+/E/jWh/jW");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("3yZ837w7voNC7K+O8SFn8H3jncDnH+Lzvz34Du4/B9+DeXLpGF/tNL6Dy2+X" +
           "Wp4FV3qIL/024Xv8HHzfkSePhNBVgG9HngXEPXsePPo2IOan/wr2fPkQ4svv" +
           "OMRXChjPnQMxP9pw8DSIQszg+KzimW9mlyXXtVXR2aN+5q2gTkLoytFB1KLw" +
           "3SEEv8WTrCCueuK2k/O7097y51+7duXx17jf353uOjqRfR8JXdEi2z551OZE" +
           "/pLnq5pZmO++3XkHrzBHJYTe/63qFkIXvd2H3oPyrjYITG98K7XzwyD578m6" +
           "IBJ8+vy6oFbxe7LW3wyhJ+5WC+gH0pPSL4bQu+4kDSRBelLywyF0/awk6L/4" +
           "PSnXAZNjLwfcaJc5KdIDrQORPNv3jhzgxPfg3Umq5OB0IH1Mko+8ma+diL2f" +
           "O3USpviPjKPjQ9HufzJuyV94bTT+/q83fmp3cla2xSzLW7lCQpd3h3iLRvMj" +
           "SO+9a2tHbV0afOAbD/3sfc8fRfMP7RTeT9sTuj1z52Oq+NoLi4Ol2T99/Bc+" +
           "9I9e+8Pig/j/AyNdnMAqMwAA");
    }
    public static final int PNG_COLOR_GRAY =
      0;
    public static final int PNG_COLOR_RGB =
      2;
    public static final int PNG_COLOR_PALETTE =
      3;
    public static final int PNG_COLOR_GRAY_ALPHA =
      4;
    public static final int PNG_COLOR_RGB_ALPHA =
      6;
    private static final java.lang.String[]
      colorTypeNames =
      { "Grayscale",
    "Error",
    "Truecolor",
    "Index",
    "Grayscale with alpha",
    "Error",
    "Truecolor with alpha" };
    public static final int PNG_FILTER_NONE =
      0;
    public static final int PNG_FILTER_SUB =
      1;
    public static final int PNG_FILTER_UP =
      2;
    public static final int PNG_FILTER_AVERAGE =
      3;
    public static final int PNG_FILTER_PAETH =
      4;
    private int[][] bandOffsets = { null,
    { 0 },
    { 0,
    1 },
    { 0,
    1,
    2 },
    { 0,
    1,
    2,
    3 } };
    private int bitDepth;
    private int colorType;
    private int compressionMethod;
    private int filterMethod;
    private int interlaceMethod;
    private int paletteEntries;
    private byte[] redPalette;
    private byte[] greenPalette;
    private byte[] bluePalette;
    private byte[] alphaPalette;
    private int bkgdRed;
    private int bkgdGreen;
    private int bkgdBlue;
    private int grayTransparentAlpha;
    private int redTransparentAlpha;
    private int greenTransparentAlpha;
    private int blueTransparentAlpha;
    private int maxOpacity;
    private int[] significantBits = null;
    private boolean suppressAlpha = false;
    private boolean expandPalette = false;
    private boolean output8BitGray = false;
    private boolean outputHasAlphaPalette =
      false;
    private boolean performGammaCorrection =
      false;
    private boolean expandGrayAlpha = false;
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam
      decodeParam =
      null;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    private boolean emitProperties = true;
    private float fileGamma = 45455 / 100000.0F;
    private float userExponent = 1.0F;
    private float displayExponent = 2.2F;
    private float[] chromaticity = null;
    private int sRGBRenderingIntent = -1;
    private int postProcess = POST_NONE;
    private static final int POST_NONE = 0;
    private static final int POST_GAMMA =
      1;
    private static final int POST_GRAY_LUT =
      2;
    private static final int POST_GRAY_LUT_ADD_TRANS =
      3;
    private static final int POST_PALETTE_TO_RGB =
      4;
    private static final int POST_PALETTE_TO_RGBA =
      5;
    private static final int POST_ADD_GRAY_TRANS =
      6;
    private static final int POST_ADD_RGB_TRANS =
      7;
    private static final int POST_REMOVE_GRAY_TRANS =
      8;
    private static final int POST_REMOVE_RGB_TRANS =
      9;
    private static final int POST_EXP_MASK =
      16;
    private static final int POST_GRAY_ALPHA_EXP =
      POST_NONE |
      POST_EXP_MASK;
    private static final int POST_GAMMA_EXP =
      POST_GAMMA |
      POST_EXP_MASK;
    private static final int POST_GRAY_LUT_ADD_TRANS_EXP =
      POST_GRAY_LUT_ADD_TRANS |
      POST_EXP_MASK;
    private static final int POST_ADD_GRAY_TRANS_EXP =
      POST_ADD_GRAY_TRANS |
      POST_EXP_MASK;
    private java.util.List<java.io.InputStream>
      streamVec =
      new java.util.ArrayList<java.io.InputStream>(
      );
    private java.io.DataInputStream dataStream;
    private int bytesPerPixel;
    private int inputBands;
    private int outputBands;
    private int chunkIndex = 0;
    private java.util.List textKeys = new java.util.ArrayList(
      );
    private java.util.List textStrings = new java.util.ArrayList(
      );
    private java.util.List ztextKeys = new java.util.ArrayList(
      );
    private java.util.List ztextStrings =
      new java.util.ArrayList(
      );
    private java.awt.image.WritableRaster
      theTile;
    private java.awt.Rectangle bounds;
    private java.util.Map properties = new java.util.HashMap(
      );
    private int[] gammaLut = null;
    private void initGammaLut(int bits) {
        double exp =
          (double)
            userExponent /
          (fileGamma *
             displayExponent);
        int numSamples =
          1 <<
          bits;
        int maxOutSample =
          bits ==
          16
          ? 65535
          : 255;
        gammaLut =
          (new int[numSamples]);
        for (int i =
               0;
             i <
               numSamples;
             i++) {
            double gbright =
              (double)
                i /
              (numSamples -
                 1);
            double gamma =
              java.lang.Math.
              pow(
                gbright,
                exp);
            int igamma =
              (int)
                (gamma *
                   maxOutSample +
                   0.5);
            if (igamma >
                  maxOutSample) {
                igamma =
                  maxOutSample;
            }
            gammaLut[i] =
              igamma;
        }
    }
    private final byte[][] expandBits = { null,
    { (byte)
        0,
    (byte)
      255 },
    { (byte)
        0,
    (byte)
      85,
    (byte)
      170,
    (byte)
      255 },
    null,
    { (byte)
        0,
    (byte)
      17,
    (byte)
      34,
    (byte)
      51,
    (byte)
      68,
    (byte)
      85,
    (byte)
      102,
    (byte)
      119,
    (byte)
      136,
    (byte)
      153,
    (byte)
      170,
    (byte)
      187,
    (byte)
      204,
    (byte)
      221,
    (byte)
      238,
    (byte)
      255 } };
    private int[] grayLut = null;
    private void initGrayLut(int bits) { int len =
                                           1 <<
                                           bits;
                                         grayLut =
                                           (new int[len]);
                                         if (performGammaCorrection) {
                                             java.lang.System.
                                               arraycopy(
                                                 gammaLut,
                                                 0,
                                                 grayLut,
                                                 0,
                                                 len);
                                         }
                                         else {
                                             for (int i =
                                                    0;
                                                  i <
                                                    len;
                                                  i++) {
                                                 grayLut[i] =
                                                   expandBits[bits][i];
                                             }
                                         }
    }
    public PNGRed(java.io.InputStream stream)
          throws java.io.IOException { this(
                                         stream,
                                         null);
    }
    public PNGRed(java.io.InputStream stream,
                  org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam decodeParam)
          throws java.io.IOException { super(
                                         );
                                       if (!stream.
                                             markSupported(
                                               )) {
                                           stream =
                                             new java.io.BufferedInputStream(
                                               stream);
                                       }
                                       java.io.DataInputStream distream =
                                         new java.io.DataInputStream(
                                         stream);
                                       if (decodeParam ==
                                             null) {
                                           decodeParam =
                                             new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                                               );
                                       }
                                       this.
                                         decodeParam =
                                         decodeParam;
                                       this.
                                         suppressAlpha =
                                         decodeParam.
                                           getSuppressAlpha(
                                             );
                                       this.
                                         expandPalette =
                                         decodeParam.
                                           getExpandPalette(
                                             );
                                       this.
                                         output8BitGray =
                                         decodeParam.
                                           getOutput8BitGray(
                                             );
                                       this.
                                         expandGrayAlpha =
                                         decodeParam.
                                           getExpandGrayAlpha(
                                             );
                                       if (decodeParam.
                                             getPerformGammaCorrection(
                                               )) {
                                           this.
                                             userExponent =
                                             decodeParam.
                                               getUserExponent(
                                                 );
                                           this.
                                             displayExponent =
                                             decodeParam.
                                               getDisplayExponent(
                                                 );
                                           performGammaCorrection =
                                             true;
                                           output8BitGray =
                                             true;
                                       }
                                       this.
                                         generateEncodeParam =
                                         decodeParam.
                                           getGenerateEncodeParam(
                                             );
                                       if (emitProperties) {
                                           properties.
                                             put(
                                               "file_type",
                                               "PNG v. 1.0");
                                       }
                                       try {
                                           long magic =
                                             distream.
                                             readLong(
                                               );
                                           if (magic !=
                                                 -8552249625308161526L) {
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder0");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           e.
                                             printStackTrace(
                                               );
                                           java.lang.String msg =
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                             getString(
                                               "PNGImageDecoder1");
                                           throw new java.lang.RuntimeException(
                                             msg);
                                       }
                                       do  {
                                           try {
                                               org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk;
                                               java.lang.String chunkType =
                                                 getChunkType(
                                                   distream);
                                               if (chunkType.
                                                     equals(
                                                       "IHDR")) {
                                                   chunk =
                                                     readChunk(
                                                       distream);
                                                   parse_IHDR_chunk(
                                                     chunk);
                                               }
                                               else
                                                   if (chunkType.
                                                         equals(
                                                           "PLTE")) {
                                                       chunk =
                                                         readChunk(
                                                           distream);
                                                       parse_PLTE_chunk(
                                                         chunk);
                                                   }
                                                   else
                                                       if (chunkType.
                                                             equals(
                                                               "IDAT")) {
                                                           chunk =
                                                             readChunk(
                                                               distream);
                                                           streamVec.
                                                             add(
                                                               new java.io.ByteArrayInputStream(
                                                                 chunk.
                                                                   getData(
                                                                     )));
                                                       }
                                                       else
                                                           if (chunkType.
                                                                 equals(
                                                                   "IEND")) {
                                                               chunk =
                                                                 readChunk(
                                                                   distream);
                                                               parse_IEND_chunk(
                                                                 chunk);
                                                               break;
                                                           }
                                                           else
                                                               if (chunkType.
                                                                     equals(
                                                                       "bKGD")) {
                                                                   chunk =
                                                                     readChunk(
                                                                       distream);
                                                                   parse_bKGD_chunk(
                                                                     chunk);
                                                               }
                                                               else
                                                                   if (chunkType.
                                                                         equals(
                                                                           "cHRM")) {
                                                                       chunk =
                                                                         readChunk(
                                                                           distream);
                                                                       parse_cHRM_chunk(
                                                                         chunk);
                                                                   }
                                                                   else
                                                                       if (chunkType.
                                                                             equals(
                                                                               "gAMA")) {
                                                                           chunk =
                                                                             readChunk(
                                                                               distream);
                                                                           parse_gAMA_chunk(
                                                                             chunk);
                                                                       }
                                                                       else
                                                                           if (chunkType.
                                                                                 equals(
                                                                                   "hIST")) {
                                                                               chunk =
                                                                                 readChunk(
                                                                                   distream);
                                                                               parse_hIST_chunk(
                                                                                 chunk);
                                                                           }
                                                                           else
                                                                               if (chunkType.
                                                                                     equals(
                                                                                       "iCCP")) {
                                                                                   chunk =
                                                                                     readChunk(
                                                                                       distream);
                                                                                   parse_iCCP_chunk(
                                                                                     chunk);
                                                                               }
                                                                               else
                                                                                   if (chunkType.
                                                                                         equals(
                                                                                           "pHYs")) {
                                                                                       chunk =
                                                                                         readChunk(
                                                                                           distream);
                                                                                       parse_pHYs_chunk(
                                                                                         chunk);
                                                                                   }
                                                                                   else
                                                                                       if (chunkType.
                                                                                             equals(
                                                                                               "sBIT")) {
                                                                                           chunk =
                                                                                             readChunk(
                                                                                               distream);
                                                                                           parse_sBIT_chunk(
                                                                                             chunk);
                                                                                       }
                                                                                       else
                                                                                           if (chunkType.
                                                                                                 equals(
                                                                                                   "sRGB")) {
                                                                                               chunk =
                                                                                                 readChunk(
                                                                                                   distream);
                                                                                               parse_sRGB_chunk(
                                                                                                 chunk);
                                                                                           }
                                                                                           else
                                                                                               if (chunkType.
                                                                                                     equals(
                                                                                                       "tEXt")) {
                                                                                                   chunk =
                                                                                                     readChunk(
                                                                                                       distream);
                                                                                                   parse_tEXt_chunk(
                                                                                                     chunk);
                                                                                               }
                                                                                               else
                                                                                                   if (chunkType.
                                                                                                         equals(
                                                                                                           "tIME")) {
                                                                                                       chunk =
                                                                                                         readChunk(
                                                                                                           distream);
                                                                                                       parse_tIME_chunk(
                                                                                                         chunk);
                                                                                                   }
                                                                                                   else
                                                                                                       if (chunkType.
                                                                                                             equals(
                                                                                                               "tRNS")) {
                                                                                                           chunk =
                                                                                                             readChunk(
                                                                                                               distream);
                                                                                                           parse_tRNS_chunk(
                                                                                                             chunk);
                                                                                                       }
                                                                                                       else
                                                                                                           if (chunkType.
                                                                                                                 equals(
                                                                                                                   "zTXt")) {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               parse_zTXt_chunk(
                                                                                                                 chunk);
                                                                                                           }
                                                                                                           else {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               java.lang.String type =
                                                                                                                 chunk.
                                                                                                                 getTypeString(
                                                                                                                   );
                                                                                                               byte[] data =
                                                                                                                 chunk.
                                                                                                                 getData(
                                                                                                                   );
                                                                                                               if (encodeParam !=
                                                                                                                     null) {
                                                                                                                   encodeParam.
                                                                                                                     addPrivateChunk(
                                                                                                                       type,
                                                                                                                       data);
                                                                                                               }
                                                                                                               if (emitProperties) {
                                                                                                                   java.lang.String key =
                                                                                                                     "chunk_" +
                                                                                                                   chunkIndex++ +
                                                                                                                   ':' +
                                                                                                                   type;
                                                                                                                   properties.
                                                                                                                     put(
                                                                                                                       key.
                                                                                                                         toLowerCase(
                                                                                                                           ),
                                                                                                                       data);
                                                                                                               }
                                                                                                           }
                                           }
                                           catch (java.lang.Exception e) {
                                               e.
                                                 printStackTrace(
                                                   );
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder2");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }while(true); 
                                       if (significantBits ==
                                             null) {
                                           significantBits =
                                             (new int[inputBands]);
                                           for (int i =
                                                  0;
                                                i <
                                                  inputBands;
                                                i++) {
                                               significantBits[i] =
                                                 bitDepth;
                                           }
                                           if (emitProperties) {
                                               properties.
                                                 put(
                                                   "significant_bits",
                                                   significantBits);
                                           }
                                       } }
    private static java.lang.String getChunkType(java.io.DataInputStream distream) {
        try {
            distream.
              mark(
                8);
            distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            distream.
              reset(
                );
            java.lang.String typeString =
              "" +
            (char)
              (type >>
                 24 &
                 255) +
            (char)
              (type >>
                 16 &
                 255) +
            (char)
              (type >>
                 8 &
                 255) +
            (char)
              (type &
                 255);
            return typeString;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private static org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk readChunk(java.io.DataInputStream distream) {
        try {
            int length =
              distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            byte[] data =
              new byte[length];
            distream.
              readFully(
                data);
            int crc =
              distream.
              readInt(
                );
            return new org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk(
              length,
              type,
              data,
              crc);
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int width =
          chunk.
          getInt4(
            0);
        int height =
          chunk.
          getInt4(
            4);
        bounds =
          new java.awt.Rectangle(
            0,
            0,
            width,
            height);
        bitDepth =
          chunk.
            getInt1(
              8);
        int validMask =
          1 <<
          1 |
          1 <<
          2 |
          1 <<
          4 |
          1 <<
          8 |
          1 <<
          16;
        if ((1 <<
               bitDepth &
               validMask) ==
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder3");
            throw new java.lang.RuntimeException(
              msg);
        }
        maxOpacity =
          (1 <<
             bitDepth) -
            1;
        colorType =
          chunk.
            getInt1(
              9);
        if (colorType !=
              PNG_COLOR_GRAY &&
              colorType !=
              PNG_COLOR_RGB &&
              colorType !=
              PNG_COLOR_PALETTE &&
              colorType !=
              PNG_COLOR_GRAY_ALPHA &&
              colorType !=
              PNG_COLOR_RGB_ALPHA) {
            java.lang.System.
              out.
              println(
                org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder4"));
        }
        if (colorType ==
              PNG_COLOR_RGB &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder5");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_PALETTE &&
              bitDepth ==
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder6");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_GRAY_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder7");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_RGB_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder8");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (emitProperties) {
            properties.
              put(
                "color_type",
                colorTypeNames[colorType]);
        }
        if (generateEncodeParam) {
            if (colorType ==
                  PNG_COLOR_PALETTE) {
                encodeParam =
                  new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
                    );
            }
            else
                if (colorType ==
                      PNG_COLOR_GRAY ||
                      colorType ==
                      PNG_COLOR_GRAY_ALPHA) {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
                        );
                }
                else {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
                        );
                }
            decodeParam.
              setEncodeParam(
                encodeParam);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setBitDepth(
                bitDepth);
        }
        if (emitProperties) {
            properties.
              put(
                "bit_depth",
                new java.lang.Integer(
                  bitDepth));
        }
        if (performGammaCorrection) {
            float gamma =
              1.0F /
              2.2F *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
            }
        }
        compressionMethod =
          chunk.
            getInt1(
              10);
        if (compressionMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder9");
            throw new java.lang.RuntimeException(
              msg);
        }
        filterMethod =
          chunk.
            getInt1(
              11);
        if (filterMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder10");
            throw new java.lang.RuntimeException(
              msg);
        }
        interlaceMethod =
          chunk.
            getInt1(
              12);
        if (interlaceMethod ==
              0) {
            if (encodeParam !=
                  null) {
                encodeParam.
                  setInterlacing(
                    false);
            }
            if (emitProperties) {
                properties.
                  put(
                    "interlace_method",
                    "None");
            }
        }
        else
            if (interlaceMethod ==
                  1) {
                if (encodeParam !=
                      null) {
                    encodeParam.
                      setInterlacing(
                        true);
                }
                if (emitProperties) {
                    properties.
                      put(
                        "interlace_method",
                        "Adam7");
                }
            }
            else {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder11");
                throw new java.lang.RuntimeException(
                  msg);
            }
        bytesPerPixel =
          bitDepth ==
            16
            ? 2
            : 1;
        switch (colorType) {
            case PNG_COLOR_GRAY:
                inputBands =
                  1;
                outputBands =
                  1;
                if (output8BitGray &&
                      bitDepth <
                      8) {
                    postProcess =
                      POST_GRAY_LUT;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
            case PNG_COLOR_RGB:
                inputBands =
                  3;
                bytesPerPixel *=
                  3;
                outputBands =
                  3;
                if (performGammaCorrection) {
                    postProcess =
                      POST_GAMMA;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_PALETTE:
                inputBands =
                  1;
                bytesPerPixel =
                  1;
                outputBands =
                  expandPalette
                    ? 3
                    : 1;
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGB;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_GRAY_ALPHA:
                inputBands =
                  2;
                bytesPerPixel *=
                  2;
                if (suppressAlpha) {
                    outputBands =
                      1;
                    postProcess =
                      POST_REMOVE_GRAY_TRANS;
                }
                else {
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                    if (expandGrayAlpha) {
                        postProcess |=
                          POST_EXP_MASK;
                        outputBands =
                          4;
                    }
                    else {
                        outputBands =
                          2;
                    }
                }
                break;
            case PNG_COLOR_RGB_ALPHA:
                inputBands =
                  4;
                bytesPerPixel *=
                  4;
                outputBands =
                  !suppressAlpha
                    ? 4
                    : 3;
                if (suppressAlpha) {
                    postProcess =
                      POST_REMOVE_RGB_TRANS;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
        }
    }
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk)
          throws java.lang.Exception { int textLen =
                                         textKeys.
                                         size(
                                           );
                                       java.lang.String[] textArray =
                                         new java.lang.String[2 *
                                                                textLen];
                                       for (int i =
                                              0;
                                            i <
                                              textLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               textKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               textStrings.
                                               get(
                                                 i);
                                           textArray[2 *
                                                       i] =
                                             key;
                                           textArray[2 *
                                                       i +
                                                       1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "text_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setText(
                                               textArray);
                                       }
                                       int ztextLen =
                                         ztextKeys.
                                         size(
                                           );
                                       java.lang.String[] ztextArray =
                                         new java.lang.String[2 *
                                                                ztextLen];
                                       for (int i =
                                              0;
                                            i <
                                              ztextLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               ztextKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               ztextStrings.
                                               get(
                                                 i);
                                           ztextArray[2 *
                                                        i] =
                                             key;
                                           ztextArray[2 *
                                                        i +
                                                        1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "ztext_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setCompressedText(
                                               ztextArray);
                                       }
                                       java.io.InputStream seqStream =
                                         new java.io.SequenceInputStream(
                                         java.util.Collections.
                                           enumeration(
                                             streamVec));
                                       java.io.InputStream infStream =
                                         new java.util.zip.InflaterInputStream(
                                         seqStream,
                                         new java.util.zip.Inflater(
                                           ));
                                       dataStream =
                                         new java.io.DataInputStream(
                                           infStream);
                                       int depth =
                                         bitDepth;
                                       if (colorType ==
                                             PNG_COLOR_GRAY &&
                                             bitDepth <
                                             8 &&
                                             output8BitGray) {
                                           depth =
                                             8;
                                       }
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             expandPalette) {
                                           depth =
                                             8;
                                       }
                                       int width =
                                         bounds.
                                           width;
                                       int height =
                                         bounds.
                                           height;
                                       int bytesPerRow =
                                         (outputBands *
                                            width *
                                            depth +
                                            7) /
                                         8;
                                       int scanlineStride =
                                         depth ==
                                         16
                                         ? bytesPerRow /
                                         2
                                         : bytesPerRow;
                                       theTile =
                                         createRaster(
                                           width,
                                           height,
                                           outputBands,
                                           scanlineStride,
                                           depth);
                                       if (performGammaCorrection &&
                                             gammaLut ==
                                             null) {
                                           initGammaLut(
                                             bitDepth);
                                       }
                                       if (postProcess ==
                                             POST_GRAY_LUT ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS_EXP) {
                                           initGrayLut(
                                             bitDepth);
                                       }
                                       decodeImage(
                                         interlaceMethod ==
                                           1);
                                       java.awt.image.SampleModel sm =
                                         theTile.
                                         getSampleModel(
                                           );
                                       java.awt.image.ColorModel cm;
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette);
                                           }
                                       }
                                       else
                                           if (colorType ==
                                                 PNG_COLOR_GRAY &&
                                                 bitDepth <
                                                 8 &&
                                                 !output8BitGray) {
                                               byte[] palette =
                                                 expandBits[bitDepth];
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               cm =
                                                 createComponentColorModel(
                                                   sm);
                                           }
                                       init(
                                         (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                           null,
                                         bounds,
                                         cm,
                                         sm,
                                         0,
                                         0,
                                         properties);
    }
    private static final int[] GrayBits8 =
      { 8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayAlphaBits8 =
      { 8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayBits16 =
      { 16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayAlphaBits16 =
      { 16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayBits32 =
      { 32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] GrayAlphaBits32 =
      { 32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBBits8 =
      { 8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBABits8 =
      { 8,
    8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBBits16 =
      { 16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBABits16 =
      { 16,
    16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBBits32 =
      { 32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBABits32 =
      { 32,
    32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel createComponentColorModel(java.awt.image.SampleModel sm) {
        int type =
          sm.
          getDataType(
            );
        int bands =
          sm.
          getNumBands(
            );
        java.awt.image.ComponentColorModel cm =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            switch (bands) {
                case 1:
                    cm =
                      colorModelGray8;
                    break;
                case 2:
                    cm =
                      colorModelGrayAlpha8;
                    break;
                case 3:
                    cm =
                      colorModelRGB8;
                    break;
                case 4:
                    cm =
                      colorModelRGBA8;
                    break;
            }
        }
        else
            if (type ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                switch (bands) {
                    case 1:
                        cm =
                          colorModelGray16;
                        break;
                    case 2:
                        cm =
                          colorModelGrayAlpha16;
                        break;
                    case 3:
                        cm =
                          colorModelRGB16;
                        break;
                    case 4:
                        cm =
                          colorModelRGBA16;
                        break;
                }
            }
            else
                if (type ==
                      java.awt.image.DataBuffer.
                        TYPE_INT) {
                    switch (bands) {
                        case 1:
                            cm =
                              colorModelGray32;
                            break;
                        case 2:
                            cm =
                              colorModelGrayAlpha32;
                            break;
                        case 3:
                            cm =
                              colorModelRGB32;
                            break;
                        case 4:
                            cm =
                              colorModelRGBA32;
                            break;
                    }
                }
        return cm;
    }
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        paletteEntries =
          chunk.
            getLength(
              ) /
            3;
        redPalette =
          (new byte[paletteEntries]);
        greenPalette =
          (new byte[paletteEntries]);
        bluePalette =
          (new byte[paletteEntries]);
        int pltIndex =
          0;
        if (performGammaCorrection) {
            if (gammaLut ==
                  null) {
                initGammaLut(
                  bitDepth ==
                    16
                    ? 16
                    : 8);
            }
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                byte r =
                  chunk.
                  getByte(
                    pltIndex++);
                byte g =
                  chunk.
                  getByte(
                    pltIndex++);
                byte b =
                  chunk.
                  getByte(
                    pltIndex++);
                redPalette[i] =
                  (byte)
                    gammaLut[r &
                               255];
                greenPalette[i] =
                  (byte)
                    gammaLut[g &
                               255];
                bluePalette[i] =
                  (byte)
                    gammaLut[b &
                               255];
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                redPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                greenPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                bluePalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
            }
        }
    }
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        switch (colorType) {
            case PNG_COLOR_PALETTE:
                int bkgdIndex =
                  chunk.
                  getByte(
                    0) &
                  255;
                bkgdRed =
                  redPalette[bkgdIndex] &
                    255;
                bkgdGreen =
                  greenPalette[bkgdIndex] &
                    255;
                bkgdBlue =
                  bluePalette[bkgdIndex] &
                    255;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette)
                       encodeParam).
                      setBackgroundPaletteIndex(
                        bkgdIndex);
                }
                break;
            case PNG_COLOR_GRAY:
            case PNG_COLOR_GRAY_ALPHA:
                int bkgdGray =
                  chunk.
                  getInt2(
                    0);
                bkgdRed =
                  (bkgdGreen =
                     (bkgdBlue =
                        bkgdGray));
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                       encodeParam).
                      setBackgroundGray(
                        bkgdGray);
                }
                break;
            case PNG_COLOR_RGB:
            case PNG_COLOR_RGB_ALPHA:
                bkgdRed =
                  chunk.
                    getInt2(
                      0);
                bkgdGreen =
                  chunk.
                    getInt2(
                      2);
                bkgdBlue =
                  chunk.
                    getInt2(
                      4);
                int[] bkgdRGB =
                  new int[3];
                bkgdRGB[0] =
                  bkgdRed;
                bkgdRGB[1] =
                  bkgdGreen;
                bkgdRGB[2] =
                  bkgdBlue;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                       encodeParam).
                      setBackgroundRGB(
                        bkgdRGB);
                }
                break;
        }
        if (emitProperties) {
            int r =
              0;
            int g =
              0;
            int b =
              0;
            if (colorType ==
                  PNG_COLOR_PALETTE ||
                  bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
                if (bitDepth <
                      8) {
                    r =
                      expandBits[bitDepth][bkgdRed];
                    g =
                      expandBits[bitDepth][bkgdGreen];
                    b =
                      expandBits[bitDepth][bkgdBlue];
                }
                else
                    if (bitDepth ==
                          16) {
                        r =
                          bkgdRed >>
                            8;
                        g =
                          bkgdGreen >>
                            8;
                        b =
                          bkgdBlue >>
                            8;
                    }
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          chunk.
            getInt4(
              0) /
            100000.0F;
        chromaticity[1] =
          chunk.
            getInt4(
              4) /
            100000.0F;
        chromaticity[2] =
          chunk.
            getInt4(
              8) /
            100000.0F;
        chromaticity[3] =
          chunk.
            getInt4(
              12) /
            100000.0F;
        chromaticity[4] =
          chunk.
            getInt4(
              16) /
            100000.0F;
        chromaticity[5] =
          chunk.
            getInt4(
              20) /
            100000.0F;
        chromaticity[6] =
          chunk.
            getInt4(
              24) /
            100000.0F;
        chromaticity[7] =
          chunk.
            getInt4(
              28) /
            100000.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setChromaticity(
                chromaticity);
        }
        if (emitProperties) {
            properties.
              put(
                "white_point_x",
                new java.lang.Float(
                  chromaticity[0]));
            properties.
              put(
                "white_point_y",
                new java.lang.Float(
                  chromaticity[1]));
            properties.
              put(
                "red_x",
                new java.lang.Float(
                  chromaticity[2]));
            properties.
              put(
                "red_y",
                new java.lang.Float(
                  chromaticity[3]));
            properties.
              put(
                "green_x",
                new java.lang.Float(
                  chromaticity[4]));
            properties.
              put(
                "green_y",
                new java.lang.Float(
                  chromaticity[5]));
            properties.
              put(
                "blue_x",
                new java.lang.Float(
                  chromaticity[6]));
            properties.
              put(
                "blue_y",
                new java.lang.Float(
                  chromaticity[7]));
        }
    }
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        fileGamma =
          chunk.
            getInt4(
              0) /
            100000.0F;
        float exp =
          performGammaCorrection
          ? displayExponent /
          userExponent
          : 1.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setGamma(
                fileGamma *
                  exp);
        }
        if (emitProperties) {
            properties.
              put(
                "gamma",
                new java.lang.Float(
                  fileGamma *
                    exp));
        }
    }
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (redPalette ==
              null) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder18");
            throw new java.lang.RuntimeException(
              msg);
        }
        int length =
          redPalette.
            length;
        int[] hist =
          new int[length];
        for (int i =
               0;
             i <
               length;
             i++) {
            hist[i] =
              chunk.
                getInt2(
                  2 *
                    i);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setPaletteHistogram(
                hist);
        }
    }
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.String name =
          "";
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            name +=
              (char)
                b;
        }
    }
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int xPixelsPerUnit =
          chunk.
          getInt4(
            0);
        int yPixelsPerUnit =
          chunk.
          getInt4(
            4);
        int unitSpecifier =
          chunk.
          getInt1(
            8);
        if (encodeParam !=
              null) {
            encodeParam.
              setPhysicalDimension(
                xPixelsPerUnit,
                yPixelsPerUnit,
                unitSpecifier);
        }
        if (emitProperties) {
            properties.
              put(
                "x_pixels_per_unit",
                new java.lang.Integer(
                  xPixelsPerUnit));
            properties.
              put(
                "y_pixels_per_unit",
                new java.lang.Integer(
                  yPixelsPerUnit));
            properties.
              put(
                "pixel_aspect_ratio",
                new java.lang.Float(
                  (float)
                    xPixelsPerUnit /
                    yPixelsPerUnit));
            if (unitSpecifier ==
                  1) {
                properties.
                  put(
                    "pixel_units",
                    "Meters");
            }
            else
                if (unitSpecifier !=
                      0) {
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder12");
                    throw new java.lang.RuntimeException(
                      msg);
                }
        }
    }
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            significantBits =
              (new int[3]);
        }
        else {
            significantBits =
              (new int[inputBands]);
        }
        for (int i =
               0;
             i <
               significantBits.
                 length;
             i++) {
            int bits =
              chunk.
              getByte(
                i);
            int depth =
              colorType ==
              PNG_COLOR_PALETTE
              ? 8
              : bitDepth;
            if (bits <=
                  0 ||
                  bits >
                  depth) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder13");
                throw new java.lang.RuntimeException(
                  msg);
            }
            significantBits[i] =
              bits;
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setSignificantBits(
                significantBits);
        }
        if (emitProperties) {
            properties.
              put(
                "significant_bits",
                significantBits);
        }
    }
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        sRGBRenderingIntent =
          chunk.
            getByte(
              0);
        fileGamma =
          45455 /
            100000.0F;
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          31270 /
            10000.0F;
        chromaticity[1] =
          32900 /
            10000.0F;
        chromaticity[2] =
          64000 /
            10000.0F;
        chromaticity[3] =
          33000 /
            10000.0F;
        chromaticity[4] =
          30000 /
            10000.0F;
        chromaticity[5] =
          60000 /
            10000.0F;
        chromaticity[6] =
          15000 /
            10000.0F;
        chromaticity[7] =
          6000 /
            10000.0F;
        if (performGammaCorrection) {
            float gamma =
              fileGamma *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
                encodeParam.
                  setChromaticity(
                    chromaticity);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
                properties.
                  put(
                    "white_point_x",
                    new java.lang.Float(
                      chromaticity[0]));
                properties.
                  put(
                    "white_point_y",
                    new java.lang.Float(
                      chromaticity[1]));
                properties.
                  put(
                    "red_x",
                    new java.lang.Float(
                      chromaticity[2]));
                properties.
                  put(
                    "red_y",
                    new java.lang.Float(
                      chromaticity[3]));
                properties.
                  put(
                    "green_x",
                    new java.lang.Float(
                      chromaticity[4]));
                properties.
                  put(
                    "green_y",
                    new java.lang.Float(
                      chromaticity[5]));
                properties.
                  put(
                    "blue_x",
                    new java.lang.Float(
                      chromaticity[6]));
                properties.
                  put(
                    "blue_y",
                    new java.lang.Float(
                      chromaticity[7]));
            }
        }
    }
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        for (int i =
               textIndex;
             i <
               chunk.
               getLength(
                 );
             i++) {
            value.
              append(
                (char)
                  chunk.
                  getByte(
                    i));
        }
        textKeys.
          add(
            key.
              toString(
                ));
        textStrings.
          add(
            value.
              toString(
                ));
    }
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int year =
          chunk.
          getInt2(
            0);
        int month =
          chunk.
          getInt1(
            2) -
          1;
        int day =
          chunk.
          getInt1(
            3);
        int hour =
          chunk.
          getInt1(
            4);
        int minute =
          chunk.
          getInt1(
            5);
        int second =
          chunk.
          getInt1(
            6);
        java.util.TimeZone gmt =
          java.util.TimeZone.
          getTimeZone(
            "GMT");
        java.util.GregorianCalendar cal =
          new java.util.GregorianCalendar(
          gmt);
        cal.
          set(
            year,
            month,
            day,
            hour,
            minute,
            second);
        java.util.Date date =
          cal.
          getTime(
            );
        if (encodeParam !=
              null) {
            encodeParam.
              setModificationTime(
                date);
        }
        if (emitProperties) {
            properties.
              put(
                "timestamp",
                date);
        }
    }
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            int entries =
              chunk.
              getLength(
                );
            if (entries >
                  paletteEntries) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder14");
                throw new java.lang.RuntimeException(
                  msg);
            }
            alphaPalette =
              (new byte[paletteEntries]);
            for (int i =
                   0;
                 i <
                   entries;
                 i++) {
                alphaPalette[i] =
                  chunk.
                    getByte(
                      i);
            }
            for (int i =
                   entries;
                 i <
                   paletteEntries;
                 i++) {
                alphaPalette[i] =
                  (byte)
                    255;
            }
            if (!suppressAlpha) {
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGBA;
                    outputBands =
                      4;
                }
                else {
                    outputHasAlphaPalette =
                      true;
                }
            }
        }
        else
            if (colorType ==
                  PNG_COLOR_GRAY) {
                grayTransparentAlpha =
                  chunk.
                    getInt2(
                      0);
                if (!suppressAlpha) {
                    if (bitDepth <
                          8) {
                        output8BitGray =
                          true;
                        maxOpacity =
                          255;
                        postProcess =
                          POST_GRAY_LUT_ADD_TRANS;
                    }
                    else {
                        postProcess =
                          POST_ADD_GRAY_TRANS;
                    }
                    if (expandGrayAlpha) {
                        outputBands =
                          4;
                        postProcess |=
                          POST_EXP_MASK;
                    }
                    else {
                        outputBands =
                          2;
                    }
                    if (encodeParam !=
                          null) {
                        ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                           encodeParam).
                          setTransparentGray(
                            grayTransparentAlpha);
                    }
                }
            }
            else
                if (colorType ==
                      PNG_COLOR_RGB) {
                    redTransparentAlpha =
                      chunk.
                        getInt2(
                          0);
                    greenTransparentAlpha =
                      chunk.
                        getInt2(
                          2);
                    blueTransparentAlpha =
                      chunk.
                        getInt2(
                          4);
                    if (!suppressAlpha) {
                        outputBands =
                          4;
                        postProcess =
                          POST_ADD_RGB_TRANS;
                        if (encodeParam !=
                              null) {
                            int[] rgbTrans =
                              new int[3];
                            rgbTrans[0] =
                              redTransparentAlpha;
                            rgbTrans[1] =
                              greenTransparentAlpha;
                            rgbTrans[2] =
                              blueTransparentAlpha;
                            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                               encodeParam).
                              setTransparentRGB(
                                rgbTrans);
                        }
                    }
                }
                else
                    if (colorType ==
                          PNG_COLOR_GRAY_ALPHA ||
                          colorType ==
                          PNG_COLOR_RGB_ALPHA) {
                        java.lang.String msg =
                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                          getString(
                            "PNGImageDecoder15");
                        throw new java.lang.RuntimeException(
                          msg);
                    }
    }
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        chunk.
          getByte(
            textIndex++);
        try {
            int length =
              chunk.
              getLength(
                ) -
              textIndex;
            byte[] data =
              chunk.
              getData(
                );
            java.io.InputStream cis =
              new java.io.ByteArrayInputStream(
              data,
              textIndex,
              length);
            java.io.InputStream iis =
              new java.util.zip.InflaterInputStream(
              cis);
            int c;
            while ((c =
                      iis.
                        read(
                          )) !=
                     -1) {
                value.
                  append(
                    (char)
                      c);
            }
            ztextKeys.
              add(
                key.
                  toString(
                    ));
            ztextStrings.
              add(
                value.
                  toString(
                    ));
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
    }
    private java.awt.image.WritableRaster createRaster(int width,
                                                       int height,
                                                       int bands,
                                                       int scanlineStride,
                                                       int bitDepth) {
        java.awt.image.DataBuffer dataBuffer;
        java.awt.image.WritableRaster ras =
          null;
        java.awt.Point origin =
          new java.awt.Point(
          0,
          0);
        if (bitDepth <
              8 &&
              bands ==
              1) {
            dataBuffer =
              new java.awt.image.DataBufferByte(
                height *
                  scanlineStride);
            ras =
              java.awt.image.Raster.
                createPackedRaster(
                  dataBuffer,
                  width,
                  height,
                  bitDepth,
                  origin);
        }
        else
            if (bitDepth <=
                  8) {
                dataBuffer =
                  new java.awt.image.DataBufferByte(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
            else {
                dataBuffer =
                  new java.awt.image.DataBufferUShort(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
        return ras;
    }
    private static void decodeSubFilter(byte[] curr,
                                        int count,
                                        int bpp) {
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int val;
            val =
              curr[i] &
                255;
            val +=
              curr[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                val;
        }
    }
    private static void decodeUpFilter(byte[] curr,
                                       byte[] prev,
                                       int count) {
        for (int i =
               0;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int prior =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   prior);
        }
    }
    private static void decodeAverageFilter(byte[] curr,
                                            byte[] prev,
                                            int count,
                                            int bpp) {
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   priorRow /
                   2);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorPixel =
              curr[i -
                     bpp] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   (priorPixel +
                      priorRow) /
                   2);
        }
    }
    private static int paethPredictor(int a,
                                      int b,
                                      int c) {
        int p =
          a +
          b -
          c;
        int pa =
          java.lang.Math.
          abs(
            p -
              a);
        int pb =
          java.lang.Math.
          abs(
            p -
              b);
        int pc =
          java.lang.Math.
          abs(
            p -
              c);
        if (pa <=
              pb &&
              pa <=
              pc) {
            return a;
        }
        else
            if (pb <=
                  pc) {
                return b;
            }
            else {
                return c;
            }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int priorPixel;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   priorRow);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            int priorRow =
              prev[i] &
              255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
                   paethPredictor(
                     priorPixel,
                     priorRow,
                     priorRowPixel));
        }
    }
    private void processPixels(int process,
                               java.awt.image.Raster src,
                               java.awt.image.WritableRaster dst,
                               int xOffset,
                               int step,
                               int y,
                               int width) {
        int srcX;
        int dstX;
        int[] ps =
          src.
          getPixel(
            0,
            0,
            (int[])
              null);
        int[] pd =
          dst.
          getPixel(
            0,
            0,
            (int[])
              null);
        dstX =
          xOffset;
        switch (process) {
            case POST_NONE:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    for (int i =
                           0;
                         i <
                           inputBands;
                         i++) {
                        int x =
                          ps[i];
                        ps[i] =
                          gammaLut[x];
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    pd[0] =
                      grayLut[ps[0]];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      grayLut[val];
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGB:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGBA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    pd[3] =
                      alphaPalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_RGB_TRANS:
                boolean flagGammaCorrection =
                  performGammaCorrection;
                int[] workGammaLut =
                  gammaLut;
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (flagGammaCorrection) {
                        pd[0] =
                          workGammaLut[r];
                        pd[1] =
                          workGammaLut[g];
                        pd[2] =
                          workGammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    if (r ==
                          redTransparentAlpha &&
                          g ==
                          greenTransparentAlpha &&
                          b ==
                          blueTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int g =
                      ps[0];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[g];
                    }
                    else {
                        pd[0] =
                          g;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    int gamma =
                      gammaLut[val];
                    pd[0] =
                      gamma;
                    pd[1] =
                      gamma;
                    pd[2] =
                      gamma;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_ALPHA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int val2 =
                      grayLut[val];
                    pd[0] =
                      val2;
                    pd[1] =
                      val2;
                    pd[2] =
                      val2;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
        }
    }
    private void decodePass(java.awt.image.WritableRaster imRas,
                            int xOffset,
                            int yOffset,
                            int xStep,
                            int yStep,
                            int passWidth,
                            int passHeight) {
        if (passWidth ==
              0 ||
              passHeight ==
              0) {
            return;
        }
        int bytesPerRow =
          (inputBands *
             passWidth *
             bitDepth +
             7) /
          8;
        int eltsPerRow =
          bitDepth ==
          16
          ? bytesPerRow /
          2
          : bytesPerRow;
        byte[] curr =
          new byte[bytesPerRow];
        byte[] prior =
          new byte[bytesPerRow];
        java.awt.image.WritableRaster passRow =
          createRaster(
            passWidth,
            1,
            inputBands,
            eltsPerRow,
            bitDepth);
        java.awt.image.DataBuffer dataBuffer =
          passRow.
          getDataBuffer(
            );
        int type =
          dataBuffer.
          getDataType(
            );
        byte[] byteData =
          null;
        short[] shortData =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            byteData =
              ((java.awt.image.DataBufferByte)
                 dataBuffer).
                getData(
                  );
        }
        else {
            shortData =
              ((java.awt.image.DataBufferUShort)
                 dataBuffer).
                getData(
                  );
        }
        int srcY;
        int dstY;
        for (srcY =
               0,
               dstY =
                 yOffset;
             srcY <
               passHeight;
             srcY++,
               dstY +=
                 yStep) {
            int filter =
              0;
            try {
                filter =
                  dataStream.
                    read(
                      );
                dataStream.
                  readFully(
                    curr,
                    0,
                    bytesPerRow);
            }
            catch (java.lang.Exception e) {
                e.
                  printStackTrace(
                    );
            }
            switch (filter) {
                case PNG_FILTER_NONE:
                    break;
                case PNG_FILTER_SUB:
                    decodeSubFilter(
                      curr,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_UP:
                    decodeUpFilter(
                      curr,
                      prior,
                      bytesPerRow);
                    break;
                case PNG_FILTER_AVERAGE:
                    decodeAverageFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_PAETH:
                    decodePaethFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                default:
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder16");
                    throw new java.lang.RuntimeException(
                      msg);
            }
            if (bitDepth <
                  16) {
                java.lang.System.
                  arraycopy(
                    curr,
                    0,
                    byteData,
                    0,
                    bytesPerRow);
            }
            else {
                int idx =
                  0;
                for (int j =
                       0;
                     j <
                       eltsPerRow;
                     j++) {
                    shortData[j] =
                      (short)
                        (curr[idx] <<
                           8 |
                           curr[idx +
                                  1] &
                           255);
                    idx +=
                      2;
                }
            }
            processPixels(
              postProcess,
              passRow,
              imRas,
              xOffset,
              xStep,
              dstY,
              passWidth);
            byte[] tmp =
              prior;
            prior =
              curr;
            curr =
              tmp;
        }
    }
    private void decodeImage(boolean useInterlacing) {
        int width =
          bounds.
            width;
        int height =
          bounds.
            height;
        if (!useInterlacing) {
            decodePass(
              theTile,
              0,
              0,
              1,
              1,
              width,
              height);
        }
        else {
            decodePass(
              theTile,
              0,
              0,
              8,
              8,
              (width +
                 7) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              4,
              0,
              8,
              8,
              (width +
                 3) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              0,
              4,
              4,
              8,
              (width +
                 3) /
                4,
              (height +
                 3) /
                8);
            decodePass(
              theTile,
              2,
              0,
              4,
              4,
              (width +
                 1) /
                4,
              (height +
                 3) /
                4);
            decodePass(
              theTile,
              0,
              2,
              2,
              4,
              (width +
                 1) /
                2,
              (height +
                 1) /
                4);
            decodePass(
              theTile,
              1,
              0,
              2,
              2,
              width /
                2,
              (height +
                 1) /
                2);
            decodePass(
              theTile,
              0,
              1,
              1,
              2,
              width,
              height /
                2);
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            theTile,
            wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        if (tileX !=
              0 ||
              tileY !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder17");
            throw new java.lang.IllegalArgumentException(
              msg);
        }
        return theTile;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QLKSoS/PtqklR7jVi4cNMNnHoqEWoUw2");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "lx3M3uK7Bf8Px/9B8dmbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL29CbTr2Fmg63OHmlJTqipTkVQqlcro5Fq2LA+pJCBPGqzJ" +
       "kmzZhuRGoy1ZkzXYsiBk6NdUSIAwJCGsQL2kOxCgM3QzNd0N/fIeNBAI3Z0s" +
       "eBB4JEyvOyGwCDTTIxCeJPsM91z73ONbVZy1tO1jbUnf/+9///vfW1tbH/2z" +
       "3GXfy+Vdx1xNTCe4okbBFcOErgQrV/Wv4ATEiJ6vKk1T9H0++e2q/Mi/vedv" +
       "vvrd03sv5G4Z5+4XbdsJxEB3bJ9VfcdcqAqRu+f417apWn6Qu5cwxIVYCAPd" +
       "LBC6HzxG5J5x4tAg9yhxiFBIEAoJQiFDKMDHuZKD7lLt0GqmR4h24M9z35o7" +
       "IHK3uHKKF+RedO1JXNETrc1pmEyC5Ay3pf8PEqGygyMv9/CR7GuZrxP4vfnC" +
       "e77/jff+xMXcPePcPbrNpThyAhEkFxnn7rRUS1I9H1YUVRnnnmmrqsKpni6a" +
       "epxxj3P3+frEFoPQU4+UlP4YuqqXXfNYc3fKqWxeKAeOdySepqumcvjfZc0U" +
       "J4mszz6WdS1hJ/09EfAOPQHzNFFWDw+5NNNtJci98PQRRzI+2k0yJIfeaqnB" +
       "1Dm61CVbTH7I3bcuO1O0JwUu8HR7kmS97ITJVYLcgztPmuraFeWZOFGvBrnn" +
       "ns7HrHcluW7PFJEeEuSedTpbdqaklB48VUonyufPqNd+1zfbqH0hY1ZU2Uz5" +
       "b0sOeujUQayqqZ5qy+r6wDtfSbxPfPbPv+NCLpdkftapzOs8//5b/uIbXvXQ" +
       "J39lnefrtuShJUOVg6vyh6W7P/P85ivqF1OM21zH19PCv0byzPyZzZ7HIjep" +
       "ec8+OmO688rhzk+yvzR664+rX76QuwPL3SI7ZmgldvRM2bFc3VQ9RLVVTwxU" +
       "BcvdrtpKM9uP5W5NvhO6ra5/pTXNVwMsd8nMfrrFyf5PVKQlp0hVdGvyXbc1" +
       "5/C7KwbT7Hvk5nK5W5Mtd2eyvT63/ss+g5xUmDqWWhBl0dZtp8B4Tiq/X1Dt" +
       "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" +
       "Czvg/r9zqU2eeo6VTm9IArIs6/FIUtpRy3rdL9tcKfsMcsKTvSVi61Y6fdfx" +
       "4ORbNhngcPTo6Tp1NjjyPzLJto4O/dNGaRcublfaDUaHvnaTo0P/lHF9Lf3/" +
       "jNGhC3ecse/ONLkt3fORNckZee++bnTo72+iUvzBxhr+YLvdXXjmuRpBn0Ua" +
       "rGorajoXJp18uZ7Gd6o/cOG+m6gYf7wB/OMdgM89V1vjOn6QPYOw7ryeBnve" +
       "nnOz0vD1SxuwL10Hdu3EjAsv3E6Y3dh+Z5pce2P7dobm+F1TMi48vCdpGoX9" +
       "6Yb0T88gTfV1Ycdg9S7SOzJSBCbJbRPeLuwxWJmhprNH/nyD+udnoKa18UJh" +
       "P9S71qjppEKiz2+jBfakrSfbX25o//IM2pToQnU/2udcQ3sVbrWu8ixMcdu4" +
       "a3typ/M3/3rD/ddncKdzMi58/X7c92fcm8mmV3l6xyzZC9+wJ3Ml2f5uw/x3" +
       "ZzBfTk+O7Mf8wBbmreaM3oSiv7qB/uoZ0Omc0wv0zSg6tYvMSHYaB7MnczpP" +
       "9msb5q+dwXxrevIdY827mO87Yk6nye5E3mMAOkOuJb5rMxF0/bkDOW1VL1zd" +
       "D/nZGTLbJulB+waaftOe2NUE99IG+9IZ2LenJ5/sh/2sk9hnKnu6J3XSbT64" +
       "dUN96xnU96Ynd27GRbeHzFUS5rrbaN09aR9JKJ+xob3jRrTLm6mBx7PUU/Bt" +
       "zNGezC9OWO/ZMN99BvMz05O/ZT/mu4/b6124b70Jg7h/g3vfGbj3pyd/fD/c" +
       "r9vRCu5if8f+odHBczbszz6D/dnpyXcMO5/dgl/roHdx7zsQjSS8z9twP+86" +
       "7nVU/P3niYpv97OnIweqfPYkcC6U/ODE8/ffqT/x67/61/e8bf2Ez7XPK2VL" +
       "MGwOPX3c5377YukZwaPvziaPHz0NcBuRu+ynOYPcw7uXc8jOtX4YaT2JJ3vW" +
       "Krf9WasHrl174kq2WsSJ6ft3n3zUMnuc9cK/uubZpu0quCpj1lXupz/3eCV7" +
       "dOmehe7rgarwm/Ulrn2i9fgp78euWXNiq5Kuyl/8xHf+yov+ZHB/tpjAWh8p" +
       "bDVadwFfszGOg8w4LuTWE/d3PbixIcoewL0qf8sPfu3Xv/Tmz3/qYu4WIndH" +
       "OsFe9FQl6aXlruxag+PkCR7lk2+t5KjHiNzd66OTTl5WrJviu+/o16PHvIPc" +
       "q3edO3uO7dTT4OkqFqazVL2GE9rZfemHTk3xD1335N6Tj4TchCF8q5d71Tl0" +
       "dyR6bvN3X2bxdx8/dJE+z3Zyp5u0DE0C5rir/IhpXx3ALAY3iHZmYenjfgft" +
       "Qxs88QjJ+gHKTCTgmodJc9EpV/H+PV3FyxI7eXDjKh7c4Sr+w3lcxR2KGIjr" +
       "h6kPBXjO4eMlrWTXiYetTyH/x/0nVR08f4P8/B3I/9d5kO/KphAxqsfokWpu" +
       "c7y/sP9t04MXbNBesAPtU+fSpp6qqyHa6wecTnP96p5ciZoOHtpwPbSD67+f" +
       "h+sZ6xtWO8E+s/8kn4MXbcBetAPst86lMHka2jPMVtRoG9dv739r6uDFG64X" +
       "7+D6/Hm4bksnunfVlX9G68GKy8xZXpX/Q+/3P/ND8Sc+un7wNW3/glz+LDd5" +
       "7cJEaTtyxqN6Jxrav0Ze88kv/dHgDRc2HuQZ14p/71niZ67qMDmp5C/sqeRC" +
       "cvZHN1d5dIeS/+RcVpkqefOYXZrzwh9dL87OC+0U58t7ivPq5Owv3VzlpTvE" +
       "+V/nirriI6PZIczOy+wU5q/2v/15sLkPsP7cIsw/nEeYO+NzFM7OK+2U5x/3" +
       "lCftNb1ic5VXbJfn4uXzyHNrMFV5/fgZyhdkjdzxDUjB04M0MmBFP1ivs3BM" +
       "ffGW/aeEH7xyQ/3KHdR3n4f6FikNjPxD6PuOoNkkrkgijPXqTydI79l/usbB" +
       "qzekr95B+pxzOXL36OboNmu556zrHIp313H0TorZpR86Jd5z93904ADYXBbY" +
       "Id4j52oPJun9VSLMYvdTE44uvvj8VFlX+pZc2k6sqZo7qF6xnSq7YZV1S48H" +
       "69ezKNLZUFnu77j2YkkH+IDcXCz7DHKzp29FLiz9ab1Ii3d4t/Cf83Lredyu" +
       "6566hXbxlXtaThLVHGweZVt/bimjHXPUTzmedEbnDsOB9hzYKOZyF8vrrOvP" +
       "LVCP7TeecXs6+ya1ndo2wNfuP55/sb4BhHYA7piWvgvwnuxZIjIpYTNFrR06" +
       "i0dOOfB0jYDsxn3zKP8pYfaYyX54I+jiYxthHtshTHc/Ye4+muu0U+XETah8" +
       "k/Xia3dQsvtRPnCtyjPelPUicoqV25MVTK7Z2LA2drCO9mO949B+i5Vt2hzv" +
       "f9PhIrIh3OWa37Qf4b3XajPjvE6T4p6cSUlfxDac2A7OPW8u3HONbW5X5763" +
       "FVJ1brzoRXwH5lmL32y7B7LFOLfrdI8FcI6sk9nAMjtgw5u0TrC0TZ2L/e88" +
       "XuxvCHs7CL/lSVlnxnmdJt98E9YpbDiFHZz/4slY53Z1/m83oc5v2mAOd2C+" +
       "88lb53advusm/PwbN7Bv3AH7PfvB3sYijZ3t0Pfuf4f5orzhu7qD7/17tpbH" +
       "ykxIt7ZAP7An5WuSq6kbSnUH5f++ZwSVzivYqcYP3oQajQ2gtgPwR246gkpR" +
       "t+rxIzehx83g+fpzC+bH9tfj7pbn4zdRXeYbQGsH4FkL1dxQj9vbnD1Wqskw" +
       "vz65nL/B9Hdg/qc925xDe9yuyJ+7CUVGG8JgB+GOYftztDkp63ZN7jGGf2SR" +
       "8YYz3sG5Ywz/Rha5vbXZYzD/KLx4ywbwm3cA7hjMP59Fbm9n9hjaP7LIt20w" +
       "37YDc8fQ/g0tcrsi9xjkP1Lkt20I376DcMcg/zktcrsmbzxOnp0tOjgIcpdL" +
       "V6pXgPSo//cMki2rHz3HMOVHD9e7G6heulbFo4ZZTXd/z7VAh5P8zwHkX3Nv" +
       "k3DsyWPv+uPv/vS7X/yFC7kD/HAF1TQ3l8sdDN76kj9PFxS5+Kf7sT+YsnPZ" +
       "MA4h+gGZrRWtKil+dorTSwGYCcdNixQ8nEPLPgYf/hFFpTmcyNFYCEOOHdf0" +
       "oUZ5UiMwWqMROUOnQEee6TEBz2bCzIph");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "81MDpeJmERmxlXhOtKpRCcQ8sDMtOC7U");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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");
}
