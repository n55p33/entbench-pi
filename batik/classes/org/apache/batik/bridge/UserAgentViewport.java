package org.apache.batik.bridge;
public class UserAgentViewport implements org.apache.batik.bridge.Viewport {
    private org.apache.batik.bridge.UserAgent userAgent;
    public UserAgentViewport(org.apache.batik.bridge.UserAgent userAgent) {
        super(
          );
        this.
          userAgent =
          userAgent;
    }
    public float getWidth() { return (float) userAgent.getViewportSize().
                                       getWidth(
                                         ); }
    public float getHeight() { return (float) userAgent.getViewportSize().
                                        getHeight(
                                          ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4Q++DTbGGCIbchdoSEVNaOBiB5MzWBhc" +
                                                              "9Ug45vbm7hbv7S67c/bZKQ1BaaGVggh1gFQJfxGRUhKiqlFbtYmoojaJklZK" +
                                                              "QpumVUjVViptihpUNa1K2/TNzO7tx92ZIrWWdm498+bNvDe/93tv9sI1VGUa" +
                                                              "qJOoNESndGKGBlQ6gg2TJCMKNs1d0BeXTlXgv+y9un1DEFXH0JwMNoclbJJB" +
                                                              "mShJM4Y6ZNWkWJWIuZ2QJJsxYhCTGBOYypoaQ/NlcyirK7Ik02EtSZjAGDai" +
                                                              "qBVTasiJHCVDlgKKOqKwkzDfSXizf7g/iholTZ9yxBe5xCOuESaZddYyKWqJ" +
                                                              "7scTOJyjshKOyibtzxtota4pU2lFoyGSp6H9ynrLBdui64tc0P1C88c3jmda" +
                                                              "uAvmYlXVKDfP3ElMTZkgyShqdnoHFJI1D6AvooooanAJU9QTtRcNw6JhWNS2" +
                                                              "1pGC3TcRNZeNaNwcamuq1iW2IYqWe5Xo2MBZS80I3zNoqKWW7XwyWNtVsFZY" +
                                                              "WWTiE6vDM6f2tnyrAjXHULOsjrLtSLAJCovEwKEkmyCGuTmZJMkYalXhsEeJ" +
                                                              "IWNFnrZOus2U0yqmOTh+2y2sM6cTg6/p+ArOEWwzchLVjIJ5KQ4o67+qlILT" +
                                                              "YOsCx1Zh4SDrBwPrZdiYkcKAO2tK5bisJila5p9RsLHnfhCAqTVZQjNaYalK" +
                                                              "FUMHahMQUbCaDo8C9NQ0iFZpAECDovaySpmvdSyN4zSJM0T65EbEEEjVcUew" +
                                                              "KRTN94txTXBK7b5Tcp3Pte0bjz2kblWDKAB7ThJJYftvgEmdvkk7SYoYBOJA" +
                                                              "TGzsi57EC146GkQIhOf7hIXMd75w/Z41nZdeEzJLSsjsSOwnEo1LZxNz3loa" +
                                                              "6d1QwbZRq2umzA7fYzmPshFrpD+vA8MsKGhkgyF78NLOH3/+0HnyYRDVD6Fq" +
                                                              "SVNyWcBRq6RldVkhxn1EJQamJDmE6oiajPDxIVQD71FZJaJ3RyplEjqEKhXe" +
                                                              "Va3x/8FFKVDBXFQP77Ka0ux3HdMMf8/rCKEaeNA6eJYg8cd/KXognNGyJIwl" +
                                                              "rMqqFh4xNGa/GQbGSYBvM+EEoH48bGo5AyAY1ox0GAMOMsQaSBhyMk3Cu4EJ" +
                                                              "N6dh0phMJnXNAKIBlOn/Z/15Zt/cyUAAXL/UH/gKxMxWTUkSIy7N5LYMXH8+" +
                                                              "/oYAFQsEyzMU9cKSIbFkiC8ZEkuGipZEgQBfaR5bWhwwHM84BDowbWPv6IPb" +
                                                              "9h3trgBk6ZOV4Fsm2u3JOBGHDWwKj0sX25qml19Z+0oQVUZRG5ZoDissgWw2" +
                                                              "0kBN0rgVvY0JyEVOSuhypQSWywxNIklgpHKpwdJSq00Qg/VTNM+lwU5YLDTD" +
                                                              "5dNFyf2jS6cnHxl7+I4gCnqzAFuyCgiMTR9h3F3g6B5/9JfS23zk6scXTx7U" +
                                                              "HB7wpBU7GxbNZDZ0+7Hgd09c6uvCL8ZfOtjD3V4HPE0xxBUccqd/DQ/N9NuU" +
                                                              "zWypBYNTmpHFChuyfVxPM4Y26fRwkLby93kAiwYWd0vhWWEFIv9lowt01i4U" +
                                                              "oGY481nBU8Ldo/rTv/jpHz7F3W1nj2ZX2h8ltN/FWExZG+emVge2uwxCQO79" +
                                                              "0yNfe+LakT0csyCxotSCPayNAFPBEYKbv/Tagfc+uHL2ctDBOYWUnUtA5ZMv" +
                                                              "GMn6Uf0sRsJqq5z9AOMpwAoMNT27VcCnnJJxQiEssP7ZvHLti3861iJwoECP" +
                                                              "DaM1N1fg9C/egg69sfdvnVxNQGIZ1/GZIyZofK6jebNh4Cm2j/wjb3c8+Sp+" +
                                                              "GhICkLApTxPOqwEr1tmmFkHNclM24ce7nsvfwds7mWu4FsTHNrBmpekOE28k" +
                                                              "umqouHT88kdNYx+9fJ3b5S3C3KgYxnq/ACJrVuVB/UI/jW3FZgbk7ry0/YEW" +
                                                              "5dIN0BgDjRLQsrnDABrNezBkSVfV/PKHryzY91YFCg6iekXDyUHMwxHVQRwQ" +
                                                              "MwMMnNc/e4+AwWQtNC3cVFRkfFEHO4plpQ95IKtTfizT31347Y3nzlzheNSF" +
                                                              "jiUF/l3q4V9eyjsUcP6dT//s3OMnJ0Ux0Fue93zzFv1jh5I4/Ju/F7mcM16J" +
                                                              "QsU3Pxa+8FR7ZNOHfL5DPWx2T744kQF9O3PXnc/+Ndhd/aMgqomhFskqncew" +
                                                              "kmMBHYNy0bTraSivPePe0k/UOf0Fal3qpz3Xsn7ScxIovDNp9t7k47lGdoRd" +
                                                              "8HRYFNDh57kA4i/38ym38baPNbfbtFKjGzJcr4iPVxpmUUpRXc6ONNZxlyBT" +
                                                              "1n6GNVGh6+5SgBRDt7FmdWFF/lftr5vcTOZGnMUCXeVYwC4lWPx1lKuBef1+" +
                                                              "9vDMmeSOZ9YKcLZ568oBuDY99/N/vRk6/evXS5Q0dVTTb1fIBFFcmwuyJT3h" +
                                                              "MMyvBw623p9z4rff60lvuZVKhPV13qTWYP8vAyP6ykeYfyuvHv5j+65NmX23" +
                                                              "UFQs87nTr/Ibwxdev2+VdCLI70IC9EV3KO+kfi/U6w0Clz51lwfwKwpIaWXA" +
                                                              "WAxPn4WUvtKJvQTICumy3NRZ0kV6ljGZNQmKatOEfk5O0oy3JGWHO5pLmFA+" +
                                                              "ylmoFiasm9S6kX3S0Z6R3wnsLS4xQcjNfzb82Ni7+9/kp1TLYFHwjQsSAB9X" +
                                                              "IdQijP4E/gLw/Js9bL+sg/0CS0Wsa1FX4V7EiH1WhvYZED7Y9sH4U1efEwb4" +
                                                              "6dgnTI7OfPWT0LEZEUjicr2i6H7rniMu2MIc1qhsd8tnW4XPGPz9xYPff/bg" +
                                                              "kaB1OjHKaFXDtHB2gULimud1utjpvV9p/sHxtopBCNAhVJtT5QM5MpT0grTG" +
                                                              "zCVcp+Dcxh3IWntmHoc7TZ+dNTk/SrPw43+RsFlHROf9e72B0Q7PWgvda289" +
                                                              "MMpNnQX8j84y9mXWPAxMCYGxlcjpDE8WWccPh/4XfshT1Fp0i2RFzaKij1Ti" +
                                                              "w4r0/Jnm2oVndr/LKbjw8aMRoiuVUxR32nW9V+sGScncrkaRhHX+c4yihWUS" +
                                                              "EZTs4oVv/TEh/zhFLX55gCj/dcvNUFTvyIEq8eIWOUVRBYiw19O6nRVbeCnH" +
                                                              "qo+QqD7yAVd+Qi4Uzr+Z9wtT3JcWxgr8I6EdODnxmRDu2Ge2bX/o+l3PiEuT" +
                                                              "pODpaaalAcJF3N8KWWR5WW22ruqtvTfmvFC30o7iVrFhB8JLXDiLQDTr7MTb" +
                                                              "fTcKs6dwsXjv7MaXf3K0+m3gnz0ogCmau6e4TsvrOUjfe6LFtAAZl191+nu/" +
                                                              "PrVpTerPv+KVMCqqf/3ycenyuQffObHoLFyJGoZQFRAUyfMC8t4pdSeRJowY" +
                                                              "apLNgTxsEbTIWPFwzhwGTsw+H3K/WO5sKvSyKzdF3cU8WvyhAm4Nk8TYouXU" +
                                                              "pMVaDU6P5+ulnYhzuu6b4PS4ck1eEJ1IKxXx6LCu22mm8kmdB+mUn3t5J5/4" +
                                                              "Tf7Kmgv/AdHe/CNAGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OJ8U5jzPGgQatWhULQd26jWWs860P/CXXj+Y9BsU7kRE3CNWVoq3Q9YSKHo1" +
       "F82Z7hMK1eUZ0vaEQeiXp8V0bQ1YvVBOyz6NSqyGwm6h4Q0IPt5Iep9bdqlq" +
       "b1RxUKywNrt9dj7w8aQk6JVJy2vGQ0+QjflK6jUG5aBXXRg+ZZhi1a2P/X7H" +
       "VnW8sWY5YbRkRDB5j5zSHVGnR9MFLracGl5nRkWDFNwGgbecSEwnrhXJk5Sp" +
       "bCYUXWTRKrEgCGLJSVMl7o1Zpl4JEnbW7GGLKiu5yDBQiovlprxamHyr12hi" +
       "rE5RczWINMKSo9UKm8ydeXNANdj2xjeqGIGXKmh7NerqAxXTuzNaxqoxLFRK" +
       "tiArxIbqT/ylPxnENuGU+kLCbBCQcaByaRQvhPG6HFqbBqbON9bQ10nPbRWi" +
       "Ro32e20dLDiJ1Zj+oIPAhWLHTufjFtdCyfWEY1Jeao7X6NiUuZWe2CWCGokW" +
       "1bII1DHE5bCVdLlRCyuRAiVSyDh1TWK5Jnr6TOFEJIFrJNnjWs0ZORpiWE8s" +
       "hgnSkWlarcEe3iNEhWmgCjXXapIM92aOZjPtlOrGpkev16ReSZi2CLdHi/Zk" +
       "3ozoAkE4nUpt0XaqjbQxLzlJsd2gB7Q/EidNPaVXCB5WCIpBZb3o6jRlz5hG" +
       "r9s0BzYswKWqEMBSOm00Zn142oG1XkInPDtdTbopxlT7c3rWqRVgZ94gRz6R" +
       "buhpXepNugtyZeA1gViFbcMVCG3UVMVxdcHrcdyha5Vmy4kX/DBCu8NFXUcC" +
       "T2uuUGHAVUjfKocINWi2Oy0+7i2L/qxcXVtmqS4Uis6ImwrjdlVwWobva3xc" +
       "Lq6aTNHTuGhepFKCG0xCPXVHEz6NE6a7MjW303NjmZqsi8WRBnMsQxfMeFqd" +
       "91tsqyozZKqWlxNUsjuJiRW6FQ2315sGGaa4ZtDsGHBGIhrarMJ1Sp2Ukc0K" +
       "9aUZm2DTThOL3eYUaycLRmgJxQLW0eRiXULDCO/XBHUQLFsIV+kMiWKSNKeS" +
       "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");
}
