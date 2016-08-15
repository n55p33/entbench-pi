package org.apache.batik.bridge;
public class SVGLineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    public SVGLineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGLineElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertStrokePainter(
            e,
            shapeNode,
            ctx);
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMLineElement le =
              (org.apache.batik.dom.svg.SVGOMLineElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX1(
                  );
            float x1 =
              _x1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY1(
                  );
            float y1 =
              _y1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX2(
                  );
            float x2 =
              _x2.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY2(
                  );
            float y2 =
              _y2.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Line2D.Float(
                  x1,
                  y1,
                  x2,
                  y2));
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_X2_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y2_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6eewjV3mzu9ndZHPsJoEkDeTe0CaG3/gaz7jhsscz9vi2" +
       "x56xTWGZ48147vFcHg9NSSK1pAUFWgKlEuSPKvRA4WhV1EqUNm3FJVAlKtRL" +
       "KqCqUmkpEvmjtCpt6Zvx794DRaE//eb5+b3vfe+73zfv8wvfQ077HpJzHXOj" +
       "mk6wA+JgRzexnWDjAn+n3cWGgucDmTQF35/AsUvSg585/4MffmB54SRyZoHc" +
       "Lti2EwiB5tj+GPiOGQG5i5w/GKVMYPkBcqGrC5GAhoFmol3NDx7rIjceWhog" +
       "F7t7JKCQBBSSgGYkoLUDKLjoZmCHFpmuEOzAXyG/gJzoImdcKSUvQB44isQV" +
       "PMHaRTPMOIAYrk+/c5CpbHHsIffv877l+TKGP5RDn/31d1z4/VPI+QVyXrPZ" +
       "lBwJEhHATRbITRawROD5NVkG8gK51QZAZoGnCaaWZHQvkNt8TbWFIPTAvpDS" +
       "wdAFXrbngeRuklLevFAKHG+fPUUDprz37bRiCirk9Y4DXrcc0uk4ZPCcBgnz" +
       "FEECe0uuMzRbDpD7jq/Y5/FiBwLApWctECyd/a2uswU4gNy21Z0p2CrKBp5m" +
       "qxD0tBPCXQLk7qsiTWXtCpIhqOBSgNx1HG64nYJQN2SCSJcEyKuPg2WYoJbu" +
       "PqalQ/r5Xv+Nz7zLbtknM5plIJkp/dfDRfceWzQGCvCALYHtwpse7X5YuOPz" +
       "T59EEAj86mPAW5g//PmX3vr6e1/88hbmNVeAGYg6kIJL0vPiLV9/LflI9VRK" +
       "xvWu42up8o9wnpn/cHfmsdiFnnfHPsZ0cmdv8sXxF+dPfAJ89yRyjkHOSI4Z" +
       "WtCObpUcy9VM4DWBDTwhADKD3ABsmczmGeQs7Hc1G2xHB4rig4BBrjOzoTNO" +
       "9h2KSIEoUhGdhX3NVpy9visEy6wfuwiCnIUPchN8Xods/7LPALmELh0LoIIk" +
       "2JrtoEPPSfn3UWAHIpTtEhWh1Ruo74QeNEHU8VRUgHawBLsToqfJKkBZrpmS" +
       "msYHuLKeDe6khub+/28Rp1xeWJ84ARXw2uPub0LPaTmmDLxL0rNhnXrpU5e+" +
       "enLfHXblEyCvh7vubHfdyXbd2e66c6VdkRMnss1ele6+1TSEMaDHw1h40yPs" +
       "29vvfPrBU9DE3PV1UMgpKHr1kEwexAgmi4QSNFTkxY+sn+TenT+JnDwaW1OK" +
       "4dC5dPkwjYj7ke/icZ+6Et7z7/nODz794cedA+86Eqx3nf7ylanTPnhctp4j" +
       "ARmGwQP0j94vfPbS5x+/eBK5DkYCGP0CAQoPBpZ7j+9xxHkf2wuEKS+nIcOK" +
       "41mCmU7tRa9zwdJz1gcjmdJvyfq3QhnfmFrzffDJ7Zp39pnO3u6m7au2RpIq" +
       "7RgXWaB9E+t+7G//8l9Kmbj3YvL5Q6ccC4LHDsWBFNn5zONvPbCBiQcAhPuH" +
       "jww/+KHvvedtmQFAiIeutOHFtCWh/0MVQjH/4pdXf/etbz7/jZMHRhPAgzAU" +
       "TU2K95lMx5Fz12AS7va6A3pgHDGho6VWc3FqW46sKZogmiC10v8+/3Dhs//2" +
       "zIWtHZhwZM+MXv/jERyM/1QdeeKr7/iPezM0J6T0HDuQ2QHYNjjefoC55nnC" +
       "JqUjfvKv7vmNLwkfg2EWhjZfS0AWrZBMBkimNDTj/9Gs3Tk2V0ib+/zDxn/U" +
       "vw7lG5ekD3zj+zdz3/+TlzJqjyYsh3XdE9zHtuaVNvfHEP2dxz29JfhLCFd+" +
       "sf9zF8wXfwgxLiBGCcYvf+DBYBMfsYxd6NNn//7P/uKOd379FHKSRs6ZjiDT" +
       "QuZkyA3QuoG/hHEqdt/y1q1y19fD5kLGKnIZ81ujuCv7dgoS+MjV4wud5hsH" +
       "LnrXfw1M8al//M/LhJBFliscs8fWL9AXPno3+ebvZusPXDxdfW98eQCGudnB" +
       "2uInrH8/+eCZL5xEzi6QC9Ju4scJZpg6zgImO/5eNgiTwyPzRxOX7Sn92H4I" +
       "e+3x8HJo2+PB5SDww34KnfbPHY4nP4J/J+Dzv+mTijsd2B6Xt5G7Z/b9+4e2" +
       "68YnoLeeLu7gO/l0/VsyLA9k7cW0+emtmtLuz0C39rOME65QNFsws43fGkAT" +
       "M6WLe9g5mIFCnVzUTTxD82qYc2fmlHK/s03btgEtbYsZiq1JYFc1n5/dQmUn" +
       "1y0HyLoOzADf+08f+Nr7H/oW1GkbOR2l8oaqPLRjP0yT4l964UP33Pjst9+b" +
       "RSkYorgnHv7uEynW7rU4Thsqbeg9Vu9OWWWz474r+EEvCyxAzri9pikPPc2C" +
       "8TfazfjQx2/7lvHR73xym80dt9tjwODpZ3/lRzvPPHvyUA790GVp7OE12zw6" +
       "I/rmXQl7yAPX2iVbQf/zpx//3O88/p4tVbcdzQgp+MLzyb/+n6/tfOTbX7lC" +
       "GnKd6bwCxQY3v69V9pna3l93OheK62lcssMkzJUScVBLpGBEiKsGZTB6Ppk0" +
       "i836pr+cW6blzHTPlkMxogEedfFVXJUNRnQMYcQZnanhsFZDKYwdb+zWLIMr" +
       "0OOAWblMezJ2XYF1RG5Fc4PVMK/Kq2lnlq8XSxOxuCiKqFJsOdrK7rIJqFYJ" +
       "olRKIjG3oIs5Faqemk1ZfTpxdYqMBK9KjUXapXBzEC9AvsFT7crA6aISaFSI" +
       "VmHJNQYDXu/Om25nPR7Np47v8YOBO+0zgTZhu3yPpDZ8QmuUE86nmLoKdWGA" +
       "aTY/7y9G9NRajnC31+wx8344cFpcf9UxLNEwmq0axcuSvGzrA8IoLEMJdyy9" +
       "bRilhZ7klxM8PwyI3pqIKxG56RTDTouos4MiNx7PSy3a0fMYVckncmtqecDJ" +
       "szaTB4Yul1dLVS7FXWPk8lE/qeSF4sSaCKGqm/N8adKJxWGRMoKZW1alcSUP" +
       "ApoweeCvc2qnE9NNvYFZGu7p3X5t0ZsTjakpiw01yJcoojSohqbUGrjsSocY" +
       "tGbHXEpsTyTb/rqyoETMduh6qyXb2NytF3kOExieH2tULtSwQi5nNMTGpuPI" +
       "402hEzhOsVymrEqjtqivp6zXbs/NVdU3EkOS2VAV6RZ871W5hVno9gvLDm/0" +
       "p3HUwysrusYXG1Z7Y7ubcM0QS6u47HKJGJc7ABslHroyGW/CDAJiUpgvyyOy" +
       "oZZrfdJKepNmaz0oyu2CwGqb8ShoCDizqepVhmzU8oHjO2OjmlSggtf1Wktq" +
       "01xnY84rQxXA03LaCQoSRU4cgzO1SVtuFjQhblrsvF5erOv+eFquc0k8q5tm" +
       "Ld8t683OvMnRKu9j3eFQB3TQjnFetswlzTDVTX7MFpWyOOfo2bxPA0NjLHWi" +
       "jkgs4mMXJYkCgbeMOWMMJNqozQaNOIflpEbFM4KIdBO6PWsU2zVirLGCIREW" +
       "L2Ni3hONaO0txoucxq+dWGEa1tBf0raryfaIERZ2RWHaq2GIdfjqEI0kZ5Mb" +
       "ReXFeL0hV8ZswiUOowTToFIw69N5WDaaOhW3FUZdaUAo9RS7XqACpSdx+kh3" +
       "bHPSYezRiIPbc51hglZIjW7X1Y61qol5rlsBlZLKW00lJ/WWdC0YdtQ2PEkZ" +
       "dKhBnx75DtRBgwrm02RU7Vvd1aRV9upLwyZFrx+3u2p10YtZXO5LveZcXC30" +
       "5nCtjrBN2+3YjDBmxJYctQPf2dRWiZQ49Biz9GaJB+N5oTuwRhV6Xat31bAZ" +
       "jcKJnzf5hVWz3aBbrKI5EYvpiAw4tTwYrpZCo7DWR6twKpULHW/ZZEs07Yzr" +
       "dt+VYxqbN23KYgClYRM+aFZzRA60YrpOJz2rUybbk+GUHvGmS1S7ZLEcTvLq" +
       "bOC6tllAxSo1n3MSN65jgqNzHM/OvH5/MIIpF9MuV+YGTUK31JKkMFrwBSqW" +
       "Gb1juDZTWK9o1s0TY4OgXCsM9TI9D+nVICZsXseG+NidDCdjAuTCRrO3dmam" +
       "2m36SyNpmk5u3W5jw0JQqvdpsiOGYVyBIRQMVgyu8ZQaeZrp85o53TTpKV0i" +
       "Ow4UZEFeaoQ10yM2kTnQWFvi3KuVsF4nZJgcqfSHOmaVLTbOM3a/2+/S4sLs" +
       "RHrddeIqbwzXUTFvz9BhXZSdRa1ZpttYYWJMNn0slEW8HqtK3cMsqd6ZLYNc" +
       "b+MQII4U1LYTLpHFpelW5Rk6nbZxpWN1KRCprODJUjWotrVmrYpWFoZAVAEY" +
       "zutDebGmlwvNokpN1FcXc6o9korDqGSXo1EutEVfqEYbaRQWi0a1RmJKm+zp" +
       "y9WKrBkSHQX4SGbt9QpTZ2a/mu8JuQ5gp3adbbObNRrwFSEY0hFWcKhSRa35" +
       "44KD8qV2rlEf4pQ8VDxenVWL0oRZagsOTIoSsHzdlpKkEwlCe1FVc5KhKLiS" +
       "VBbK2udqIhO78w1b0sgxt25p9SAgMRllYjQipThYSL3VJocSS6VlChjF5n3L" +
       "ayXCUFH0ykTExfUS74o5fykOR0y12G1UlpvRLK73Jl64NkdNAmzKfQXH+tFs" +
       "1O0w5cZ4ZLKeN2sth5t5B6316nhYqdoSqvDD3HomaZ3GptY0R/JmPZjXY2tV" +
       "zxEWpy5YgcDLeG1Ihv1+odcdx1OuOSaoac0NSdOdlmZ2MnU4VPRX6wAUFZEo" +
       "8pG0Wcf1Od5UyqSy8Ek8EtF4Rm3iRLEJz2mSWmJ3ZHKQ0xK9UMytNgSGm33H" +
       "RJ1OJwlRmSSiaOIpOAFlOmh1NlyH1UswluRXFttZ6RsJX9ojvsAwy9JqjOWA" +
       "XjXNPorSdAlEoWzWqGYFd/uOpaBmmRkJRGhXQZ3v6mjRzM9w3CekiBn0Ip1V" +
       "E63RxteVKmjObCE0p1YLGIxrzGSxQ2slj9BgYGo7LZ4v9rWeoSYyGnJgpDhz" +
       "RgxUC+jldU2EwZmjvMokKcxM0xSYip3nMF+c+wzQXH2SF/AVVeCbo6XVC5f1" +
       "nthYN3h9KtN9omwP/WKTAlAlSlWXG3TNI1rLRiys3HgAvHmlx+eq0hDwPGeS" +
       "da7ZHFgoVRvPi2orUCzPFiobjzOdZSuR23yZxF0hGcxzdYkYjHM1mZ5N6Bjn" +
       "/OKgxq9LXqNAmkafZFoVi07qC6c+nk7L/lzz9ALPQQFIc7PkD0YxDrze1FQ4" +
       "vzAw1U3RLw6nvO7Epg/TD4Y213nep1c6XluyVYrcsOO1XDdHXH1GcFiOUnr1" +
       "oUdWFAzMsFyjiVEij897UFdlHW/NuWGpJy51vi1O4NHDBy6Pd9D+0jKKSatR" +
       "mRQmI4xW5gTJd2DeVHR8V+oVakbBZMvBpMl1u+P8lKhg/ZJglMvDtljAUFZm" +
       "nTJJYSq1Gdgovomr1MTN81VKl9qdsj8g0DLcWqjj+Li/Giz0HDNTc6MqbtXV" +
       "3rpfnsrKCBtXXTM36QWrqmPxJubyWEKv20TYGtqxXC5LZBKsilNzXFiw4aaN" +
       "4cNWeVZieqXyOFKBtIkJuSWGFGgrLS2f9Du1ZDoczOVaW+8VaFVqagV4Eo3W" +
       "A2fRtq3yigTooKQ26UVALWbKKqx3S0Wx0YsbclNI2h2bcjHBztcmcX/BLAp5" +
       "c+j30bKi+aU6K8IkGeY3YBR2u+GMGi/aedSKvdK8kzTQYrOfRNgGK1sCHbDB" +
       "yqvAf7RWUeNJu82G3bjvhEYhNwhwgyl1MEqCwZqtalGTXDeIYWECmEmBKiho" +
       "FEdqLq4Aqt5RWstxyaIdVVP9Xq67tKIl2ERSB6xVw8cbKiHjqtTeOIAJTSxw" +
       "S2GphzUDj4sFo1HCChV7YQSeSkym6iwJy0CJdCuScm2qwhrlwFyMV9NYtzx6" +
       "PhGVApuPWKJocmLfS4Qib+aCWQjl2tVFvy5VNRtTiqOlOk9Igq/PsRlnKzlz" +
       "OAMhX4zQXLuciOFoRS5GJNWLLbQuzxhXHOiaXpTrgwnBVpeQvKqED5VJwbNd" +
       "C1NKpRWOo3YdstK1BrzZk4csDZQSmvOm62i4Vqy1NK5zoyKjhbPW1KFVfOGx" +
       "1XHb2cSFZjKPZvacCWpjqbViOqukD/j1ZCSag6a77DrxokkohfJKSwajqlld" +
       "E1OPXQ7CHl/q2425pYmWHMAMpKsWR2slHI28UG4X10K31mfwRk3NjfsDUZ5X" +
       "HTZfLtu8jSW+VotrzbrAlDeyIlTtNjxvgygnmjWaUorDBmeTKm1Mx8Sm0ZDy" +
       "ZqO60lpa2evW5jOyM7J8eUUSqO8RKJZjQ4IiitGwoIQF2QQStYBvX29KX8ve" +
       "/vLejG/NLgH2CznwhTidaL2MN8Lt1ANp8/D+xWH2d+b45f/hi8OD2yQkfcu9" +
       "52r1mewN9/mnnn1OHny8cHL3Fm4WIDcEjvsGE0TAPIQqrUU+evW3+V5Wnjq4" +
       "HfrSU/969+TNy3e+jDvv+47ReRzl7/Ze+ErzddKvnURO7d8VXVY4O7rosaM3" +
       "ROc8EISePTlyT3TPvmRvSyV2L3zyu5LNX/ne+YpWcCKzgq3ur3HJ6V9jLkwb" +
       "O0BuUkHQdSTB7O+S3jowF+fHXSAcRpoNGEf5uwc++C5/+E+ev3dfY+7JtEkC" +
       "5EbI356G9m7E7r1azWZbpTkQwLtegQBekw4W4dPYFUDj5QgAOobrOQGQAiBf" +
       "UQ6ndm9wd1l6+Nos7Vap96BvT6HXJWlHdqyd3QrV1YWjRsEOuxRc0HdkkBHz" +
       "zDUE/+G0eTpA7pQ8IASA1kyTDTzHgA6YVaT39nng6vschsz08MuvQA+37Onh" +
       "7bt6eNvLNcT3XUsB6df3p82vps0HM9DfvIZ4nk+bjwXIOTHUTDljN4NjD8Vn" +
       "PkCuixxNPhDAc69AAFmF6w3weWpXAE/+ZDzxxG6Nclefpcv0mRqXH6k7NVuz" +
       "0vvurhaBWhB4mhgGILubz/D+3jWk9dm0eQEa5VKw4fm4h2kfCwnHVSCnUL91" +
       "IK1PvhxpxQHyqivVatPC012X/SZk+zsG6VPPnb/+zuemf5OVK/d/a3BDF7le" +
       "CU3zcJ3gUP+M6wFFy/i6YVs1cLOPP4bOchX3DZAz4kFM+twW/k8D5MJx+AA5" +
       "nX0ehvtzaGUHcBDVtnMY5AsBcgqCpN0vunuarFyjpN0AkpMVLzLLPSKw+MTR" +
       "ZGBfHbf9OHUcyh8eOnLqZ7/c2Tuhw+1vdy5Jn36u3X/XS5WPb2uukikkSYrl" +
       "+i5ydlv+3T/lH7gqtj1cZ1qP/PCWz9zw8F5GcsuW4AOPOETbfVcucFKWG2Ql" +
       "yeSP7vyDN/72c9/Mqhz/B8UMl8BSJQAA");
}
