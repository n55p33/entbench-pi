package org.apache.batik.bridge;
public class SVGMaskElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.MaskBridge {
    public SVGMaskElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_MASK_TAG; }
    public org.apache.batik.gvt.filter.Mask createMask(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.w3c.dom.Element maskElement,
                                                       org.w3c.dom.Element maskedElement,
                                                       org.apache.batik.gvt.GraphicsNode maskedNode) {
        java.lang.String s;
        java.awt.geom.Rectangle2D maskRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertMaskRegion(
            maskElement,
            maskedElement,
            maskedNode,
            ctx);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.CompositeGraphicsNode maskNode =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        org.apache.batik.gvt.CompositeGraphicsNode maskNodeContent =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        maskNode.
          getChildren(
            ).
          add(
            maskNodeContent);
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               maskElement.
               getFirstChild(
                 );
             node !=
               null;
             node =
               node.
                 getNextSibling(
                   )) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                node;
            org.apache.batik.gvt.GraphicsNode gn =
              builder.
              build(
                ctx,
                child);
            if (gn ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            maskNodeContent.
              getChildren(
                ).
              add(
                gn);
        }
        if (!hasChildren) {
            return null;
        }
        java.awt.geom.AffineTransform Tx;
        s =
          maskElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                convertTransform(
                  maskElement,
                  SVG_TRANSFORM_ATTRIBUTE,
                  s,
                  ctx);
        }
        else {
            Tx =
              new java.awt.geom.AffineTransform(
                );
        }
        short coordSystemType;
        s =
          maskElement.
            getAttributeNS(
              null,
              SVG_MASK_CONTENT_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  maskElement,
                  SVG_MASK_CONTENT_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  Tx,
                  maskedNode);
        }
        maskNodeContent.
          setTransform(
            Tx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          maskedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              maskedNode.
                getGraphicsNodeRable(
                  true);
        }
        return new org.apache.batik.gvt.filter.MaskRable8Bit(
          filter,
          maskNode,
          maskRegion);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVZe8wsSVXv+933Zdl79y7sriv75C64O+vX09PzdFmge6Zn" +
       "eqa7Z3qme16tcOl39/Rz+jHTPbC6EBWUBBF3cY2wf0FUsjxiJJoYzBqjQCAm" +
       "GOIrEYgxEUUS9g/RiIrVPd/7PshGnWRqaqpOnTrn1Dm/OlX10nehs2EAFXzP" +
       "TnXbi3bVJNpd2JXdKPXVcLdHV1gxCFWlaYthyIO26/Kjn7v8/R982LiyA50T" +
       "oLtF1/UiMTI9NxypoWevVIWGLh+2ErbqhBF0hV6IKxGOI9OGaTOMnqKh1xwZ" +
       "GkHX6H0RYCACDESAcxFg7JAKDHqt6sZOMxshulG4hH4WOkVD53w5Ey+CHjnO" +
       "xBcD0dljw+YaAA4Xsv8ToFQ+OAmghw903+p8g8LPF+Dnfv2dV373NHRZgC6b" +
       "LpeJIwMhIjCJAN3hqI6kBiGmKKoiQHe5qqpwamCKtrnJ5Ragq6Gpu2IUB+qB" +
       "kbLG2FeDfM5Dy90hZ7oFsRx5wYF6mqnayv6/s5ot6kDXew513WrYztqBgpdM" +
       "IFigibK6P+SMZbpKBD10csSBjtcoQACGnnfUyPAOpjrjiqABurpdO1t0dZiL" +
       "AtPVAelZLwazRND9t2Sa2doXZUvU1esRdN9JOnbbBagu5obIhkTQ60+S5ZzA" +
       "Kt1/YpWOrM93+2/50Ltd0t3JZVZU2c7kvwAGPXhi0EjV1EB1ZXU78I4n6I+K" +
       "93zhAzsQBIhff4J4S/P773nl7U8++PKXtjQ/fhOagbRQ5ei6/Anpzq+9ofl4" +
       "43QmxgXfC81s8Y9pnrs/u9fzVOKDyLvngGPWubvf+fLoz+bPfkr9zg50qQud" +
       "kz07doAf3SV7jm/aatBRXTUQI1XpQhdVV2nm/V3oPKjTpqtuWweaFqpRFzpj" +
       "503nvPw/MJEGWGQmOg/qpqt5+3VfjIy8nvgQBJ0HX+gB8H0ztP28KSsi6Dps" +
       "eI4Ki7Lomq4Hs4GX6R/CqhtJwLYGLAGvt+DQiwPggrAX6LAI/MBQ9zqkwFR0" +
       "FeYmHUYMrQwfwEg8b9zNHM3//58iybS8sj51CizAG06Gvw0ih/RsRQ2uy8/F" +
       "OPHKZ65/ZecgHPbsE0FPgll3t7Pu5rPubmfdvdms0KlT+WSvy2bfrjRYJwtE" +
       "PMDCOx7n3tF71wcePQ1czF+fAUbOSOFbQ3LzECO6ORLKwFGhl19Yv3fyc8Ud" +
       "aOc4tmYSg6ZL2XA2Q8QD5Lt2MqZuxvfy+7/9/c9+9BnvMLqOgfVe0N84Mgva" +
       "R0/aNvBkVQEweMj+iYfFz1//wjPXdqAzAAkA+kUi8FYALA+enONY8D61D4SZ" +
       "LmeBwpoXOKKdde2j16XICLz1YUu+6Hfm9buAjV+TefND4Pvknnvnv1nv3X5W" +
       "vm7rJNmindAiB9qnOf/jf/3n/4Tm5t7H5MtHdjlOjZ46ggMZs8t5xN916AN8" +
       "oKqA7u9eYH/t+e++/6dzBwAUb7zZhNeysgniHywhMPMvfGn5N9/8xie+vnPo" +
       "NBHYCGPJNuXkQMmsHbp0GyXBbG86lAfgiA0CLfOaa2PX8RRTM0XJVjMv/c/L" +
       "jyGf/5cPXdn6gQ1a9t3oyR/N4LD9x3Do2a+8898ezNmckrN97NBmh2RbcLz7" +
       "kDMWBGKayZG89y8e+I0vih8HMAugLTQ3ao5WUG4DKF80ONf/ibzcPdGHZMVD" +
       "4VHnPx5fR/KN6/KHv/69106+90ev5NIeT1iOrjUj+k9t3SsrHk4A+3tPRjop" +
       "hgagK7/c/5kr9ss/ABwFwFEG+BUOAgA2yTHP2KM+e/5v//hP7nnX105DO23o" +
       "ku2JSlvMgwy6CLxbDQ2AU4n/trdvF3d9ARRXclWhG5TfOsV9+b/TQMDHb40v" +
       "7SzfOAzR+/5jYEvv+/t/v8EIObLcZJs9MV6AX/rY/c23ficffxji2egHkxsB" +
       "GORmh2NLn3L+defRc3+6A50XoCvyXuI3Ee04CxwBJDvhfjYIksNj/ccTl+0u" +
       "/dQBhL3hJLwcmfYkuBwCP6hn1Fn90lE8+SH4nALf/86+mbmzhu12ebW5t2c/" +
       "fLBp+35yCkTr2dJubbeYjX9bzuWRvLyWFW/eLlNW/QkQ1mGecYIRmumKdj7x" +
       "2yPgYrZ8bZ/7BGSgYE2uLexazub1IOfO3SnTfnebtm0BLStLOYutS1Ru6T4/" +
       "taXKd647D5nRHsgAP/gPH/7qr7zxm2BNe9DZVWZvsJRHZuzHWVL8iy89/8Br" +
       "nvvWB3OUAhA1efax7zybcaVvp3FWEFnR3lf1/kxVLt/uaTGMmBxYVCXX9rau" +
       "zAamA/B3tZfxwc9c/ab1sW9/epvNnfTbE8TqB5775R/ufui5nSM59BtvSGOP" +
       "jtnm0bnQr92zcAA9crtZ8hHtf/zsM3/428+8fyvV1eMZIQEOPJ/+y//66u4L" +
       "3/ryTdKQM7b3v1jY6I4yWQ672P6HnszF0lqeJNNCjJZryirpzj3Z0sIRMjbH" +
       "SbyZRDrj95YqKpoyKzIzYamPB5uYjzYKqpklwe1t2kitNup1KXvc16qexwv+" +
       "cKnV7OWSXnJlnSLoIbW0RlJbwMXusqnjJl+wCYXoVvm0W9sMYo2VSwpCDKUW" +
       "h/asRqORbGqo3ajU07raQ8fTpuQLxpKtT6etqUQki3GDL5bodEl4UXW9GFoR" +
       "ZVOrJTpPGn10VLcjrW9pgiBaCYWU6EVz0nfEHlKiBLez5ORUnFubTlthnLBi" +
       "VjjaMUW4b1mlXr+CJRNrNCws5ZDpqKLncHhkk32eU8cVB8UIuU9N9B5LJGPX" +
       "XBdI3xuOfMsdLUpTTSM7mNaS17pQr2lpgbL6s06Tjnpl14yWLNWea5ShW4tS" +
       "JzAr7qSHktMuSfJLo0aOGJmL1xEzJrVlWtLQVjqTRmOnRGAID86k7DTuTKVl" +
       "NR0MCVHr+PM0oKec1kOK9kRfrmmGZDkXxdCFPHBkZTFGFMnVIwZlAK9OY9oe" +
       "ROlk0om6ahMfRIZMM6LRk8vVuThrO1a7xZIK2p5HzRLSYKdI0COSeVQrG3JM" +
       "TlcN3pj4Dgc254VIJxVSJ/B1yRmqrdBOKUcR13SrX3GDkV8eJIJg+uPJZC7z" +
       "NUXiLHHBYnCs1EvNhN7gPN1xpXS17hYMp2JOY6dSqYqj9nATFMSI8DZeJyaD" +
       "ahyV+QU3lNsdfFgBCOcSrjSwVIscCUSlujbDOqnFcBNL11GzRqptCY2WwZTC" +
       "8W6cFE0qGqf1idVluWIraI2rONXqpYJIDSNyivvjqdid2wzXa2l9ttQmMaRJ" +
       "sDphlUuG4hA9tsXZfnOGraoAPWardKwiOrIcjwYthvH7Y5atV6f9oTJd8K1i" +
       "mFgWppXWS0kxRcVPCpHrlYdYvTofhnV0AzYfRSWbeqEeSP0QnjKLlByn6jzp" +
       "sdzUCRpqI+ooDUQzZNUDzkoPVXkmctVU6i+FDufN9RamuBYnL2iHn5SEQt2f" +
       "8XQNg0dFd4FTzkRpTTV9YywtmJM9ccGwDFYUbHpQwVxu3RpVJkzCWi2/zJu6" +
       "GFYdslhy6PrQ5oKhzwVcraCXXa6L9foItmBNX5qiU7VVXyZl2jAJq7Usc7gi" +
       "KwlbixKG5H06CXqVhcz5I14hiwWa8z24MiVxzMUlqZ/YzLAxjBKuXpCIbi9B" +
       "5Q1BySPcXlg8NRmMmHRdGKCKbtkebWLmWraGw3lieMmqAZvr3jKeEj6hE6SE" +
       "xe5qvRRkBJ8J07njD1cVSyIkOtW0aMzQxXonaaVyK+ysGHQxdhQPFeK6RNXG" +
       "nklIpDACUNRY8GVxSKSk2URFRQu7ZXXgFkqBbmAbexngKbMQJ8ioOnKRuUwT" +
       "dUpCOTRIU1gJdAdpcy7XiiaDXmXpdO0OP9/obZLTfbbDc5bHuZWoiqFj3EyW" +
       "vllOOmLTH3vI2u/zgVlPiIEpS1hCy6k3rnSWDblfX6ouklZW5MipGSt0RDjF" +
       "GN/o9mKKCbRR71ikjBVWBQZLx1ZjlSaEqq1YukgpRdKg6GrZl9qWP/WGSL1M" +
       "MrTDjZc1tWAHqaKwjWG86a9xXV57PWDoOalUF81OoTMbJJ2Z6uNlaRRXliY1" +
       "rlb7HdSdIj2lbnoLvr/q1Am5Z5KcoLeQdYu3RGpQr5Q6LaNUcjt9eSRxw4jr" +
       "wBLbCWtwoTCCV21VKKVFg/bYGsssymO9WR4jZgVbhkW2lDLOvN5Cy+rM99OK" +
       "qhUoz2y7ekytZGNVLC/0nqUPV/imW4A1jWqhCCLFSYCUK0mrJlddDxsvVcIz" +
       "XZ5Xh5Y7l0QFJj2s0JYw3KtK8HyImuOiFfSpccpTCRwN1nNtUFzxNUmURayZ" +
       "DEsLXQnp+sDROmbHRTdoqVEqGz2zZ1S1SVQJWEGla7i9SULHHQobhCjX0dos" +
       "alTNTbFnYy2uZONjB+vNu8C7jIhGmjC6ItR2w6u5TLlGN5vrSUGelYkpxTlK" +
       "DPtJvbEhpcZ66KdoHM6pgrvkOxaOqIPBOtTZxYBp6Yrfnk8Lg2qNWc0mk9WM" +
       "4gWs3Eq6tt7eBCHmlqdNk2p11Zofl1EWrW7KsFGbcMMqb/gTVw4Wk+ZQEOct" +
       "T7DnU4+e6NqgjZdqNt3gm8WmPemZWtfGW6M1j7qzhQqCw0sb9RU6qBUqNW01" +
       "Fc0W3bIDAqFYPCZZoVznhEI0rVTkAoyrLGOPGH4jWLUq5RFwN6j3C9PFKLD8" +
       "vlkyy4hRrYHcWtOc2lAywX6fxDijGpsZHNgsWhdjeFNT6v7YXYtxp9KYlrge" +
       "j9VVuuwLbWHa5xokU1DIUhlerUHgNrWO5PCm1ynWotUYZzcaVgzCwF7ja0up" +
       "VGsELPFuOmSlMjnHYb5uynOB1Fx3k7hDpuZr/VFR2ohxG+Ya+HzV0T2xvZgj" +
       "nRnvd5bLnt0RR92ZUgkVauApRB+pYjxVZm1MMhiHdNYTx/XpIa7XDGEzq0sG" +
       "V1kXBbGJFNPpkveIkuQDje0NniwQp1+omOUVU970Fz2GHWk9s8sZOoK7AHXb" +
       "TIyu6ZlWnJGwK8RuMaKGTTFoD0VfGc2UcWrJtXYFQfuCUsPQ7grlVm2hVZzJ" +
       "sFd0mWW11Y/opDOeqmqKcfNS2LVtnmDxJoHO6VVhtB4wlZ5XGqZifzhqIxt/" +
       "NZ3aQ4QZ0MgQiNYum1p5tWpz2GKJyOOyD/Jh16ooSmEu9NWZU/JrSNIotOUm" +
       "JaWzpSl1C7OROhkyPlFMtWnYt8TxzENLw1m7yMr2YuEHA8yoYq0QR8nqSIhg" +
       "fNxFN0yjt5B0sgC2TW1WLBCdMYy37YGMdNs0a5QTF2vUezZV5qmQ4l0q1FK6" +
       "nyZtLAgrMl72A45vAl5xJe2tOAmnh64+dlNFppiVRKamvpzUG3125i3kekFA" +
       "Fd+y/Nkk5AOaTpXSurTAy5pEFf2NoIxVlJxsYDHsD6q9wZiWBBwWN3In1Oee" +
       "aqwMa04gUZOebyY1dJyS1U2kFvquUFppRtkv2sTQ8/v0aM3IeKFYnBeWWB2h" +
       "OoumVOdwvrIylcpS7MubdF1nfBauTpGOZWpoM6wCYyFUtbBaL1YbE1aHSDUk" +
       "x7yPiVQvXTFWUWqrjiE4JZLzFjbrGJMgwHASb1rUhFO62qTC87EkGL21Xt20" +
       "65RKgQ0oWmwckTUXxQLCchydjGzUS3VvYpsVz1SR0mjUpfBiQeDMWirEI9mS" +
       "Ro6J83BbjqX2uFHli8WWImkuF6+mnjwO8K4rtsoDM9bqS39Sbw+oWa0iSkKr" +
       "0YfXIDUv0jQ6rBKr1oDTYq+OOAYCxzHWK/HsRJ3wxFo0wkiqF9kWv6RcmTbm" +
       "w5bnWkpx0JYJd+4qVIFV0xJb4FSGNxytjhmbalFozyfglPB0dnx4x6s7wd2V" +
       "H1YPHhzAwS3rIF/FyWXb9UhWPHZwwZV/zu1fTu//Hr3gOrz1OLV/MH70Vle3" +
       "2b3t9sI2O7g9cKsnh/zQ9on3PfeiMvgksrN3sTSLoIuR5/+kra5U+8isO4DT" +
       "E7c+oDL5i8vhhccX3/fP9/NvNd71Kq5xHzoh50mWv8O89OXOm+SP7ECnD64/" +
       "bngLOj7oqeOXHpcCNQJYwx+7+njgYBGuZjZ/EHyRvUVAbn6VelOHOZU7zNZN" +
       "bnNvF9+mb50V4Cx8h65GtCeLdn9PdPLQs5Y/6kx8lGne4Bzol5PdD75P7+n3" +
       "9P+NfmdygjP7bvnYrdxy65J7D4771Hdn1GtU3lU8Z3fvsSHr+vl9gkduYKev" +
       "ot1OIPqGKYd9T1Fzod57G8P+Ula8J4IuyYEqRmoWHvvcH74pd820IzXYPSDM" +
       "Tf/MqzF9EkGvu9kLSnYdfN8NL7Xb10X5My9evnDvi+O/yh8RDl4AL9LQBS22" +
       "7aO3d0fq5/xA1cxcz4vbuzw///lIBN17i5WIoHPbSi72r27pn4+gKyfpI+hs" +
       "/nuU7gVgx0M6wGpbOUrymxF0GpBk1Y/5+5Yu3cotMNd0xCi7Xs9vFk0Z2G0P" +
       "vU4dAaA9d86X4uqPWoqDIUdfITLQyt/S9wEm3r6mX5c/+2Kv/+5Xqp/cvoLI" +
       "trjZZFwu0ND57YPMAUg9cktu+7zOkY//4M7PXXxsH1Dv3Ap8GFpHZHvo5k8O" +
       "hONH+SPB5g/u/b23/NaL38jvHf8HvtGlZOQgAAA=");
}
