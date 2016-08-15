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
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4Q++DTbGGCIbchdoSEVNaOBiB5MzWBhc" +
                                                              "9Ug45vbm7hbv7S67c/bZKQ1BaaGVggh1gFYJfxGRUhKiqFFbtYmoojaJklZK" +
                                                              "QpumVUjVViptihpUNa1K2/TNzO7tx92ZIrWWdm498+bNvDe/93tv9sI1VGUa" +
                                                              "qJOoNESndGKGBlQ6gg2TJCMKNs1d0BeXTlXgv+y9un1DEFXH0JwMNoclbJJB" +
                                                              "mShJM4Y6ZNWkWJWIuZ2QJJsxYhCTGBOYypoaQ/NlcyirK7Ik02EtSZjAGDai" +
                                                              "qBVTasiJHCVDlgKKOqKwkzDfSXizf7g/iholTZ9yxBe5xCOuESaZddYyKWqJ" +
                                                              "7scTOJyjshKOyibtzxtota4pU2lFoyGSp6H9ynrLBdui64tc0P1888c3jmda" +
                                                              "uAvmYlXVKDfP3ElMTZkgyShqdnoHFJI1D6AvooooanAJU9QTtRcNw6JhWNS2" +
                                                              "1pGC3TcRNZeNaNwcamuq1iW2IYqWe5Xo2MBZS80I3zNoqKWW7XwyWNtVsFZY" +
                                                              "WWTiE6vDM6f2trxQgZpjqFlWR9l2JNgEhUVi4FCSTRDD3JxMkmQMtapw2KPE" +
                                                              "kLEiT1sn3WbKaRXTHBy/7RbWmdOJwdd0fAXnCLYZOYlqRsG8FAeU9V9VSsFp" +
                                                              "sHWBY6uwcJD1g4H1MmzMSGHAnTWlclxWkxQt888o2NhzPwjA1JosoRmtsFSl" +
                                                              "iqEDtQmIKFhNh0cBemoaRKs0AKBBUXtZpczXOpbGcZrEGSJ9ciNiCKTquCPY" +
                                                              "FIrm+8W4Jjildt8puc7n2vaNxx5St6pBFIA9J4mksP03wKRO36SdJEUMAnEg" +
                                                              "Jjb2RU/iBS8dDSIEwvN9wkLmO1+4fs+azkuvCZklJWR2JPYTicals4k5by2N" +
                                                              "9G6oYNuo1TVTZofvsZxH2Yg10p/XgWEWFDSywZA9eGnnjz9/6Dz5MIjqh1C1" +
                                                              "pCm5LOCoVdKyuqwQ4z6iEgNTkhxCdURNRvj4EKqB96isEtG7I5UyCR1ClQrv" +
                                                              "qtb4/+CiFKhgLqqHd1lNafa7jmmGv+d1hFANPGgdPEuQ+OO/FD0QzmhZEsYS" +
                                                              "VmVVC48YGrPfDAPjJMC3mXACUD8eNrWcARAMa0Y6jAEHGWINJAw5mSbh3cCE" +
                                                              "m9MwaUwmk7pmANEAyvT/s/48s2/uZCAArl/qD3wFYmarpiSJEZdmclsGrj8X" +
                                                              "f0OAigWC5RmKemHJkFgyxJcMiSVDRUuiQICvNI8tLQ4YjmccAh2YtrF39MFt" +
                                                              "+452VwCy9MlK8C0T7fZknIjDBjaFx6WLbU3Ty6+sfSWIKqOoDUs0hxWWQDYb" +
                                                              "aaAmadyK3sYE5CInJXS5UgLLZYYmkSQwUrnUYGmp1SaIwfopmufSYCcsFprh" +
                                                              "8umi5P7RpdOTj4w9fEcQBb1ZgC1ZBQTGpo8w7i5wdI8/+kvpbT5y9eOLJw9q" +
                                                              "Dg940oqdDYtmMhu6/Vjwuycu9XXhF+MvHezhbq8DnqYY4goOudO/hodm+m3K" +
                                                              "ZrbUgsEpzchihQ3ZPq6nGUObdHo4SFv5+zyARQOLu6XwrLACkf+y0QU6axcK" +
                                                              "UDOc+azgKeHuUf2pX/z0D5/i7razR7Mr7Y8S2u9iLKasjXNTqwPbXQYhIPf+" +
                                                              "6ZGvPXHtyB6OWZBYUWrBHtZGgKngCMHNX3rtwHsfXDl7OejgnELKziWg8skX" +
                                                              "jGT9qH4WI2G1Vc5+gPEUYAWGmp7dKuBTTsk4oRAWWP9sXrn2xT8daxE4UKDH" +
                                                              "htGamytw+hdvQYfe2Pu3Tq4mILGM6/jMERM0PtfRvNkw8BTbR/6Rtzu+/ip+" +
                                                              "ChICkLApTxPOqwEr1tmmFkHNclM24ce7nsvfwds7mWu4FsTHNrBmpekOE28k" +
                                                              "umqouHT88kdNYx+9fJ3b5S3C3KgYxnq/ACJrVuVB/UI/jW3FZgbk7ry0/YEW" +
                                                              "5dIN0BgDjRLQsrnDABrNezBkSVfV/PKHryzY91YFCg6iekXDyUHMwxHVQRwQ" +
                                                              "MwMMnNc/e4+AwWQtNC3cVFRkfFEHO4plpQ95IKtTfizT31347Y3nzlzheNSF" +
                                                              "jiUF/l3q4V9eyjsUcP6dT//s3OMnJ0Ux0Fue93zzFv1jh5I4/Ju/F7mcM16J" +
                                                              "QsU3Pxa+8GR7ZNOHfL5DPWx2T744kQF9O3PXnc/+Ndhd/aMgqomhFskqncew" +
                                                              "kmMBHYNy0bTraSivPePe0k/UOf0Fal3qpz3Xsn7ScxIovDNp9t7k47lGdoRd" +
                                                              "8HRYFNDh57kA4i/38ym38baPNbfbtFKjGzJcr4iPVxpmUUpRXc6ONNZxlyBT" +
                                                              "1n6GNVGh6+5SgBRDt7FmdWFF/lftr5vcTOZGnMUCXeVYwC4lWPx1lKuBef1+" +
                                                              "9vDMmeSOp9cKcLZ568oBuDY9+/N/vRk6/evXS5Q0dVTTb1fIBFFcmwuyJT3h" +
                                                              "MMyvBw623p9z4rff60lvuZVKhPV13qTWYP8vAyP6ykeYfyuvHv5j+65NmX23" +
                                                              "UFQs87nTr/Kbwxdev2+VdCLI70IC9EV3KO+kfi/U6w0Clz51lwfwKwpIaWXA" +
                                                              "WAxPn4WUvtKJvQTICumy3NRZ0kV6ljGZNQmKatOEfk5O0oy3JGWHO5pLmFA+" +
                                                              "ylmoFiasm9S6kX3S0Z6R3wnsLS4xQcjNfyb82Ni7+9/kp1TLYFHwjQsSAB9X" +
                                                              "IdQijP4E/gLw/Js9bL+sg/0CS0Wsa1FX4V7EiH1WhvYZED7Y9sH4k1efFQb4" +
                                                              "6dgnTI7OfPWT0LEZEUjicr2i6H7rniMu2MIc1qhsd8tnW4XPGPz9xYPff+bg" +
                                                              "kaB1OjHKaFXDtHB2gULimud1utjpvV9p/sHxtopBCNAhVJtT5QM5MpT0grTG" +
                                                              "zCVcp+Dcxh3IWntmHoc7TZ+dNTk/SrPw43+RsFlHROf9e72B0Q7PWgvda289" +
                                                              "MMpNnQX8j84y9mXWPAxMCYGxlcjpDE8WWccPh/4XfshT1Fp0i2RFzaKij1Ti" +
                                                              "w4r03Jnm2oVndr/LKbjw8aMRoiuVUxR32nW9V+sGScncrkaRhHX+c4yihWUS" +
                                                              "EZTs4oVv/TEh/zhFLX55gCj/dcvNUFTvyIEq8eIWOUVRBYiw19O6nRVbeCnH" +
                                                              "qo+QqD7yAVd+Qi4Uzr+Z9wtT3JcWxgr8I6EdODnxmRDu2Ge2bX/o+l1Pi0uT" +
                                                              "pODpaaalAcJF3N8KWWR5WW22ruqtvTfmPF+30o7iVrFhB8JLXDiLQDTr7MTb" +
                                                              "fTcKs6dwsXjv7MaXf3K0+m3gnz0ogCmau6e4TsvrOUjfe6LFtAAZl191+nu/" +
                                                              "MbVpTerPv+KVMCqqf/3ycenyuQffObHoLFyJGoZQFRAUyfMC8t4pdSeRJowY" +
                                                              "apLNgTxsEbTIWPFwzhwGTsw+H3K/WO5sKvSyKzdF3cU8WvyhAm4Nk8TYouXU" +
                                                              "pMVaDU6P5+ulnYhzuu6b4PS4ck1eEJ1IKxXx6LCu22mm8gWdB+mUn3t5J5/4" +
                                                              "Lf7Kmgv/AX+3SHNAGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6acwr11Xzvre/JnkvaZukafa8FBKXb2zPeBmllNpjj+0Z" +
       "ezz2bB7T9nU8uz2bZ/GMXULTImhppRBBuoDaCKRWQJUuQlQgoaIgBG3VCqmo" +
       "YpNoK4REoVRqflAQBcqd8be/JUSApbke33vOueece865557rF78HnQ0DqOB7" +
       "9tqwvWhXS6PduV3Zjda+Fu6S/QojB6Gm4rYchhzou6Y8+vnLP/jhc+aVHejc" +
       "FHqt7LpeJEeW54ZjLfTslab2ocuHvW1bc8IIutKfyysZjiPLhvtWGD3Vh15z" +
       "BDWCrvb3WYABCzBgAc5ZgBuHUADpds2NHTzDkN0oXEI/C53qQ+d8JWMvgh45" +
       "TsSXA9nZI8PkEgAKF7LfAhAqR04D6OED2bcyXyfwhwvw8x9955XfOQ1dnkKX" +
       "LZfN2FEAExGYZArd5mjOTAvChqpq6hS609U0ldUCS7atTc73FLortAxXjuJA" +
       "O1BS1hn7WpDPeai525RMtiBWIi84EE+3NFvd/3VWt2UDyHr3oaxbCYmsHwh4" +
       "yQKMBbqsaPsoZxaWq0bQQycxDmS8SgEAgHre0SLTO5jqjCuDDuiu7drZsmvA" +
       "bBRYrgFAz3oxmCWC7rsp0UzXvqwsZEO7FkH3noRjtkMA6mKuiAwlgl5/Eiyn" +
       "BFbpvhOrdGR9vke/5dl3u113J+dZ1RQ74/8CQHrwBNJY07VAcxVti3jbk/2P" +
       "yHd/8QM7EASAX38CeAvzez/z8tve/OBLX97CvPEGMMPZXFOia8onZ3d8/X78" +
       "Cex0xsYF3wutbPGPSZ6bP7M38lTqA8+7+4BiNri7P/jS+E+lZz6tfXcHutSD" +
       "zimeHTvAju5UPMe3bC3oaK4WyJGm9qCLmqvi+XgPOg/e+5arbXuHuh5qUQ86" +
       "Y+dd57z8N1CRDkhkKjoP3i1X9/bffTky8/fUhyDoPHigMnjeCG0/+XcEvR02" +
       "PUeDZUV2LdeDmcDL5A9hzY1mQLcmPANWv4BDLw6ACcJeYMAysANT2xuYBZZq" +
       "aDAfakHDAEiCpSW+F4CwA6zM/3+mn2byXUlOnQKqv/+k49vAZ7qerWrBNeX5" +
       "uNl++bPXvrpz4Ah7momgJ8CUu9spd/Mpd7dT7l43JXTqVD7T67KptwsMlmcB" +
       "HB2EwNueYN9BvusDj54GluUnZ4BuM1D45pEYPwwNvTwAKsA+oZc+lrxXeE9x" +
       "B9o5HlIzdkHXpQydyQLhQcC7etKVbkT38vu/84PPfeRp79CpjsXoPV+/HjPz" +
       "1UdPKjbwFE0F0e+Q/JMPy1+49sWnr+5AZ0AAAEEvkoGRAo09eHKOYz771H78" +
       "y2Q5CwTWvcCR7WxoP2hdiszASw578hW/I3+/E+j4NZkR3w+ex/asOv/ORl/r" +
       "Z+3rthaSLdoJKfL4+pOs/4m/+rN/RHJ174fiy0c2N1aLnjri/hmxy7mj33lo" +
       "A1ygaQDubz/G/MqHv/f+n84NAEA8dqMJr2YtDtweLCFQ889/efnX3/rmJ7+x" +
       "c2g0Edj/4pltKemBkFk/dOkWQoLZ3nTIDwgfNnCxzGqu8q7jqZZuyTNby6z0" +
       "Py4/XvrCPz97ZWsHNujZN6M3vzKBw/43NKFnvvrOf30wJ3NKybavQ50dgm1j" +
       "4msPKTeCQF5nfKTv/fMHfvVL8idAdAURLbQ2Wh6kTu05TsbU60EC8IqumS8v" +
       "nMM/mbe7mWpyKlA+hmTNQ+FRNznuiUcSkmvKc9/4/u3C9//w5Vyu4xnNUasY" +
       "yP5TW0PMmodTQP6ekzGhK4cmgENfot9+xX7ph4DiFFBUQIwLhwGISekxG9qD" +
       "Pnv+b/7oj+9+19dPQzsEdMn2ZJWQc3eELgI/0EIThLPU/6m3bc0guQCaK7mo" +
       "0HXCb83n3vzXGcDgEzePRESWkBw6873/PrRn7/u7f7tOCXkMusE+fAJ/Cr/4" +
       "8fvwt343xz8MBhn2g+n1cRokb4e45U87/7Lz6Lk/2YHOT6Eryl5mKMh2nLnY" +
       "FGRD4X66CLLHY+PHM5vtNv7UQbC7/2QgOjLtyTB0uD+A9ww6e790IvLclmn5" +
       "YfA8sOeUD5yMPKeg/KWRozySt1ez5sf2Hf28H1grsO3vefqPwOcUeP4rezJi" +
       "Wcd2k74L38sUHj5IFXywdV2M9/0gI1DchrqsRbOmuaVbu6m5vCVriPQUYOVs" +
       "ebe2mxOgbszu6ez1x0FwCvN0GWDolivbuVKICJi/rVzdZ1IA6TOwl6tzu7bv" +
       "yVdyU89WZnebc57glfgf8wpM+Y5DYn0PpK8f+vvnvvZLj30L2BsJnV1ltgDM" +
       "7MiMdJxl9L/w4ocfeM3z3/5QHmuB/oVnHv/uMxlV4VYSZ80wa5h9Ue/LRGXz" +
       "dKUvh9EgD4+amkt7SzdjAssBu8hqL12Fn77rW4uPf+cz21T0pE+dANY+8PwH" +
       "f7T77PM7Rw4Aj12Xgx/F2R4CcqZv39NwAD1yq1lyDOIfPvf0H/zW0+/fcnXX" +
       "8XS2DU5rn/mL//za7se+/ZUbZFJnbO9/sbDR7X4XDXuN/U9fkHQx4dNU1IcI" +
       "BqOjQqHFzTodvDdTTNVj2wItD5tWszLYiE1TwXgDraxmTs2crWpstabAsyk1" +
       "KjVluSMYhlkyCInU086YNylrSRCzSHI8by6TCxuA+bEj8HNBsPzIMn2elktU" +
       "GebozbAWpVh52gtEUXVQrF6Y0auWBmNItMLCXkno8PKSHHp0m3XVDtVp2qOq" +
       "YZQ5Eh9QdFhSi01twtkTY1VYY7FbarWJSbdIJgPaU+wZSTYd1iQHqFSd0uJC" +
       "JMVePC2PSDJMJRPnOs2htPY9eQTTtrK2AqrWWxTL7YidzhudlmwtmwInhxbZ" +
       "xYWWbVDUcEkli01LZyfWRq8ZsAX2Cm6KrdOmVknxYdxm5amqSmtKXJK1UOGG" +
       "5HoemtRwbc2iTRqBGI/6fNkmvHWH9atdbO0G/aYaW1U0UopMqV6vK8jcUeW4" +
       "sXIkeyJQLZ1B2vaAmy6MNWsuVdfrEmSv1Ko2Vh74yG6D5LERF40VOqmSpkiz" +
       "5ZLfwRFOGdNTjZbpRJGdeFmyxHJPWopaZeKVB80pWy/2kA3tLSlRrE2StUhH" +
       "QkhMJVHkrHZ11RpU9XIUpCNj6s+XhC2OMbtM0kbb5AULJXCWG7daCJkOFs5o" +
       "EMl+UqaY9qLftrhS6CLijJLHE67bXMO18Ux01CGZqGpRb0xcvC9Nh5K9HIed" +
       "OtHQeEzABDYk/LArNqVqnChkq2Sg3dLA2QzYTrfhcqKt2Km4SEcRUI5Xps0N" +
       "k8wbJdILvbEThQRrW8t2Kxo5PYowabOoNDXHk8dUWGxQzSY/iaa+spkM/VlH" +
       "mQbtDktiikVbOMUtY5yRiF7gFOoiSs4tW43qfqzU3PJKptO0wkZVv0n0GhiJ" +
       "OouQKSIJNR4iVVYl2/yg4bYNcj4rj3nYarJ1tcX22smKxpJF3xmWCqgeFuTN" +
       "Il7h04VNiuMyyUicpch2iC4qs3WZxjpVT6Jjr8QJ3NTTV+E07ZYlo1T04Ykh" +
       "tkWixa6TaQPTOq4732BwtbWpDHrzpVnCSz7uVPpD3BNUah0vkxG6qVptg+YW" +
       "Zoqr/Jger+Zom1o2saoVtqNOrVfh1/i4hNujYLWMZihcwC2CMo3+ctlVSzYt" +
       "63Jt7jidVUEtmUSDZjqGyrTjUWE4hIlWcbRxzGk7lFjBEQQcrUudgNFbDWZO" +
       "DnDEmTRwvlXX6EBUGuPGQC5K1Xmj3e2IPZpsJBWHnZmIgrcdbJDIfOIsar7T" +
       "oNuN9YqDQxith2U4nuKNRmDDyxaSEJIjB77Fku2p6ih22Anm9YleHDYsQ8Qr" +
       "Y4fSnC65IIx1SioDixVaYz62Rj18RffqUX+ESnNHURpmWYoCAsEGRFRAK2Uh" +
       "wdfYwKbqeJGr6dOF25u3mnOZSKtif8Yj3LpaCHVW7FHLodfiw6KZiuKoJc1k" +
       "ueHI6ppCQqldwXsuOWErvNHvTyXJWbCjhA9cXuo4fomVe4nu+U6ssxKuAGsO" +
       "zHrsWBWmNvbVITdHE0xvK6PmrDQ18NK0OeI6vldPalYlUXt1uLBY+TOussa0" +
       "YZ9MsGXLwNCit1RbUuQMzLgKC/MkXisxNpmYRGGw6mobc7ast9ylJKGGN4zV" +
       "ITj9q07BQahpMOONsO1vFNMyR8iUWVbdDj+cqV0PZYlVpbBZN8ajYT+uTpKg" +
       "38AXemFdHPFVOVUovjVUgNUalNaNeb3sT+BNsVWBrVogb8a1QVCT6mw5xqw+" +
       "JYfzCc0tE2Y2GUlmj9EL1WlnxUy60bpZHYrTpsSLQbMbTTsG5Rr4oEtPkCBK" +
       "uqE+adm1oTY33Haf2liiUQ8Xk3mHw5ZdVOyVOyVBqRQMps1LDRFotqZScZPj" +
       "wgXqjRuiyGDhJHDLKVdX5bSN8lSra0Yd2VlHScFUVyNJ18pMjHBL1On1O4Mq" +
       "PB+0x4MiE+njFb1I6k1uNoar42gTF2DLL+BmD1/0Gz6XMsNl0g5KkeMQiy6t" +
       "2IMyqmg1N1zpiRrWHDFGiZDr0kHT8bXFsF2uL2Jn6cVdrl5fqLSUFjCdRGYV" +
       "FsERypBSdwk3cDIQYqEJ8z14LiLE1JgtasG6CEttsaL26GLTaM3H/VEYuK1G" +
       "M6C1TXPBCroAM1Q3WG8krCQRuFG1tMWktea7gyTtCqNxMhokg4FLK7CGFhqJ" +
       "OIpoHFEEYrzQiXZ3iPq2P8IqPSridGvDISUErUmIu7E3pkazxNziCdhGlqiA" +
       "aWBX4hWmqnIwHCLDgUsW+bRIxBqGbDbEqjQ3Kz0UJmOYqDnKoFQlRyGPMKlc" +
       "qHfGtSk97Or9SosR0zJXQ9HFiMCGCDNxFbhAq6YKywNj6TkmES6WIO9PFs6g" +
       "2ZXodXHGBTJrrRiN0YoLmB/qRUIG/PgbZBK6NVZJe96qRftYVFugNbujemO1" +
       "3h1LBN0yK7VFA7VgpL52kPpMZuiZPosIat7ZkEqAWoyQ+g7P++OJUh3S9DS1" +
       "102u5FY7tNAxq4UKazTHrahGOKpIAB3oUVBZgc152nEHPD7RBCnBUVtk0pIN" +
       "DE7TSwUMbIGOxg59TKGU/rRSrXvNuCVhBZiGV+NFFdZWIBqMiqrAcbOS3msS" +
       "hOIALyU5xBwM1qtmUi0jPrZBA12vFu1VPBUokxFKyJITJaa+aqyZ6nqhSfo6" +
       "XnVXlXmhWqGdSRnhiVFYr7lcAFOzJFW1VbkgqHi/Vyv2cKwtINSwsNAtmK8m" +
       "RdzeVEp2oidU4vdkcdIQGynjoiK/iihyNeJ6eOysEXo8LS6Eqj3vTOmRQ8nR" +
       "sK0vKsOit0bIjtgdVvy+QzQKa9vxCEsOHYytLiYIW5xWx0jihn0WTUfKnNbX" +
       "s3qZtmoFDF74Ja4vEd1kPgrZRhOb9NSRNWfQNmz0E5gMsVm/EBpwEWeLYiiX" +
       "iAkq1NpWtySaK2nabtUkLOyii5KmE6MZWlUNl+vVhjojcsV+e9rm55YSlK1q" +
       "txa41iAuD3pKaWmGaj1yRXTCdJgNlkqMrhdmxkJulobzLiUTk1bUbZYNvm85" +
       "sVqKo7m/EjAfDrsg4/KbON0wBTLiKqNBZeBzRSPgOhtcUPxCS0lNpCe6kdP1" +
       "lBo3LahgF4XZgElQpDAOCbs7HuqYVis3i6MaIxorVS7XscHAp93RpD6vo2vM" +
       "mYhMIx3gUie1lbnfatdFUVEYE0YnemhyJcIvWuUxsZEpa17irAQNigjpOmVP" +
       "cNUA7lOzeVKXB2PPigU+HSNlV8SEQthhFVcJFvLY7E4KCrq2TJFn21MuRD1h" +
       "BXNtE96YRH9SqRj4HFaVFc0T3Grday/rWk8c8sK4KVlJCRtW3bEw03C3u/QK" +
       "o2Wrtm4IamFkofwmKEyxJOIQUhFTI6j3qm112HJTZ9yKyx2tPJvAXsEuMVYx" +
       "5vxhy5dl2W4oJIHQdZAxjiuiWC4H8TJacbrDEAWk6NUsISDMZp3sT1pWf9Ti" +
       "gtqAm+mcQoVVNQkn81VtIE90hCqCfcpwN0XPwB05rmooF66CIT/XtWqfiBqN" +
       "qV3CSgU3hgczwee0gFkVKGGAL5c6jKwVzV3HI10fzrpen1iTHW86IsYNfq0P" +
       "8HqE+iqrjUkvkWS/TxtcGrZnXE9kiGRjJh0uTApdhILFYSWkVuya2qgEovB1" +
       "cbU2Gw5KL+qc5MUT3h8IcouvMpVCbLuSuYnj6gxlWFQBRtsmSz0qnaTVPh6X" +
       "y45TN0S1WXB4F4kqZAVG+3qNcowV3JgUELZLNzrgiJUdvYxXd/q9Mz/oH9w0" +
       "gUNvNjB+Fae+7dAjWfP4QTUl/5w7eTtxtMR5WM06KA8+fLPy4H7BPjvyPnCz" +
       "m6b8uPvJ9z3/gjr8VGlnr1w4i6CLwDN/wtZWmn1kzh1A6cmbH+0H+UXbYRnr" +
       "S+/7p/u4t5rvehVl/IdO8HmS5G8PXvxK503KL+9Apw+KWtddAR5Heup4KetS" +
       "oEVx4HLHCloPHCxBvgxvAM+Te0vw5I1L6TeuZuXmsjWSW1Rj33OLsfdmzSaC" +
       "LhhaJFpqZOZQ7zhiTnJWdbI9OTo0tHe/Unnh6Cx5R3Jc4PvAU9oTuPR/L/Cz" +
       "txh7Lmt+ERgcELirWYaZV/F+7lC4D74a4VLgm9fdWGXl93uvuxDfXuIqn33h" +
       "8oV7XuD/Mr+0ObhovdiHLuixbR+tgR55P+cHmm7l/F/cVkT9/OujEXTPTdwx" +
       "gs5tX3KeP7KF/7UIunISHixv/n0U7hMRdOkQDpDavhwF+fUIOg1Astff8G9Q" +
       "cNyWgtNTR9x5zxZyLd/1Slo+QDl6p5OFgPwPCfvuGm//knBN+dwLJP3ul6uf" +
       "2t4pKba82WRULvSh89vrrQOXf+Sm1PZpnes+8cM7Pn/x8f3wdMeW4UO7PMLb" +
       "Qze+wGk7fpRfuWx+/57ffctvvvDNvP7536WUQ4gpIgAA");
}
