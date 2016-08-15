package org.apache.batik.bridge;
public class SVGColorProfileElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public org.apache.batik.ext.awt.color.NamedProfileCache cache = new org.apache.batik.ext.awt.color.NamedProfileCache(
      );
    public java.lang.String getLocalName() { return SVG_COLOR_PROFILE_TAG;
    }
    public org.apache.batik.ext.awt.color.ICCColorSpaceExt createICCColorSpaceExt(org.apache.batik.bridge.BridgeContext ctx,
                                                                                  org.w3c.dom.Element paintedElement,
                                                                                  java.lang.String iccProfileName) {
        org.apache.batik.ext.awt.color.ICCColorSpaceExt cs =
          cache.
          request(
            iccProfileName.
              toLowerCase(
                ));
        if (cs !=
              null) {
            return cs;
        }
        org.w3c.dom.Document doc =
          paintedElement.
          getOwnerDocument(
            );
        org.w3c.dom.NodeList list =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_COLOR_PROFILE_TAG);
        int n =
          list.
          getLength(
            );
        org.w3c.dom.Element profile =
          null;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.w3c.dom.Node node =
              list.
              item(
                i);
            if (node.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element profileNode =
                  (org.w3c.dom.Element)
                    node;
                java.lang.String nameAttr =
                  profileNode.
                  getAttributeNS(
                    null,
                    SVG_NAME_ATTRIBUTE);
                if (iccProfileName.
                      equalsIgnoreCase(
                        nameAttr)) {
                    profile =
                      profileNode;
                }
            }
        }
        if (profile ==
              null)
            return null;
        java.lang.String href =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            profile);
        java.awt.color.ICC_Profile p =
          null;
        if (href !=
              null) {
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 profile).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL pDocURL =
              null;
            if (baseURI !=
                  null) {
                pDocURL =
                  new org.apache.batik.util.ParsedURL(
                    baseURI);
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              pDocURL,
              href);
            if (!purl.
                  complete(
                    ))
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ERR_URI_MALFORMED,
                  new java.lang.Object[] { href });
            try {
                ctx.
                  getUserAgent(
                    ).
                  checkLoadExternalResource(
                    purl,
                    pDocURL);
                p =
                  java.awt.color.ICC_Profile.
                    getInstance(
                      purl.
                        openStream(
                          ));
            }
            catch (java.io.IOException ioEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ioEx,
                  ERR_URI_IO,
                  new java.lang.Object[] { href });
            }
            catch (java.lang.SecurityException secEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  secEx,
                  ERR_URI_UNSECURE,
                  new java.lang.Object[] { href });
            }
        }
        if (p ==
              null) {
            return null;
        }
        int intent =
          convertIntent(
            profile,
            ctx);
        cs =
          new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
            p,
            intent);
        cache.
          put(
            iccProfileName.
              toLowerCase(
                ),
            cs);
        return cs;
    }
    private static int convertIntent(org.w3c.dom.Element profile,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String intent =
          profile.
          getAttributeNS(
            null,
            SVG_RENDERING_INTENT_ATTRIBUTE);
        if (intent.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_PERCEPTUAL_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     PERCEPTUAL;
        }
        if (SVG_AUTO_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_RELATIVE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     RELATIVE_COLORIMETRIC;
        }
        if (SVG_ABSOLUTE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     ABSOLUTE_COLORIMETRIC;
        }
        if (SVG_SATURATION_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     SATURATION;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          profile,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_RENDERING_INTENT_ATTRIBUTE,
          intent });
    }
    public SVGColorProfileElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "eCCfCuISH+SrX+Jd1vzg3zVVhCJCGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aecwrV3Wf970t7xHyXhJI0jQ7L7QvQ7/xPrYe0IzH9niZ" +
       "1faMx0PLy6z22LN5Fs94aEpApdBQAWrDUgnyFwhKw1JU1EoVVaqqBQSqRIW6" +
       "SQVUVSotRSJ/lFalLb0z/rb3vSWNqGpprq/vPffcc84953fP3OsXvg+dDnwI" +
       "9lxrM7PccFdPwt2FVd0NN54e7PbJKiv7ga7hlhwEY9B2VX3s8xd++KMPzC/u" +
       "QGck6G7ZcdxQDk3XCYZ64FprXSOhC4etbUu3gxC6SC7ktYxEoWkhpBmEV0jo" +
       "VUeGhtAlcl8EBIiAABGQXAQEO6QCg16tO5GNZyNkJwxW0C9DJ0jojKdm4oXQ" +
       "o9cy8WRftvfYsLkGgMNt2W8BKJUPTnzokQPdtzpfp/AHYeS5D7/14hdOQhck" +
       "6ILpjDJxVCBECCaRoNtt3VZ0P8A0Tdck6E5H17WR7puyZaa53BJ0V2DOHDmM" +
       "fP3ASFlj5Ol+Pueh5W5XM938SA1d/0A9w9Qtbf/XacOSZ0DXew513WrYydqB" +
       "gudNIJhvyKq+P+TU0nS0EHr4+IgDHS8NAAEYetbWw7l7MNUpRwYN0F3btbNk" +
       "Z4aMQt90ZoD0tBuBWULo/psyzWztyepSnulXQ+i+43TstgtQncsNkQ0Jodce" +
       "J8s5gVW6/9gqHVmf79NvfN/bnK6zk8us6aqVyX8bGPTQsUFD3dB93VH17cDb" +
       "nyA/JN/zpffsQBAgfu0x4i3N7//SS0++4aEXv7Kl+ekb0DDKQlfDq+rHlTu+" +
       "8QB+uXEyE+M2zw3MbPGv0Tx3f3av50rigci754Bj1rm73/ni8M+mz3xa/94O" +
       "dL4HnVFdK7KBH92purZnWrpP6I7uy6Gu9aBzuqPheX8POgvqpOno21bGMAI9" +
       "7EGnrLzpjJv/BiYyAIvMRGdB3XQMd7/uyeE8ryceBEFnwQM9CJ4noO3nclaE" +
       "0AyZu7aOyKrsmI6LsL6b6R8guhMqwLZzRAFev0QCN/KBCyKuP0Nk4Adzfa9D" +
       "8U1tpiMjgQBiuz4Yn8mT4QTg0Mw7dzOH8/7/pkoyrS/GJ06ABXngOBxYIJK6" +
       "rqXp/lX1uajZfumzV7+2cxAee/YKoQqYfXc7+24+++529t1bzQ6dOJFP+ppM" +
       "iq0HgPVbAiQAGHn75dEv9p96z2Mnget58Slg/IwUuTlU44fY0csRUgUODL34" +
       "kfgdwtsLO9DOtZibSQ6azmfD2QwpDxDx0vFYuxHfC+/+7g8/96Gn3cOouwbE" +
       "98Dg+pFZMD923Ma+q+oagMdD9k88In/x6peevrQDnQIIAVAxlIEXA8B56Pgc" +
       "1wT1lX2AzHQ5DRQ2XN+WraxrH9XOh3PfjQ9b8sW/I6/fCWz8ELRX7Lt9/p31" +
       "3u1l5Wu2zpIt2jEtcgB+08j72F//+T+Vc3PvY/WFI7vfSA+vHMGHjNmFHAnu" +
       "PPSBsa/rgO7vPsL+5ge//+635A4AKF53owkvZSUOcAEsITDzu76y+ptvf+vj" +
       "39w5dJoQbJCRYplqslXyx+BzAjz/nT2ZclnDNrbvwvcA5pEDhPGymV9/KBvw" +
       "ZQsEYeZBl3jHdjXTMGXF0jOP/c8Ljxe/+C/vu7j1CQu07LvUG16ewWH7TzWh" +
       "Z7721n97KGdzQs32ukP7HZJtAfTuQ86Y78ubTI7kHX/x4G99Wf4YgGIAf4GZ" +
       "6jmiQbk9oHwBC7kt4LxEjvWVsuLh4GggXBtrR3KSq+oHvvmDVws/+KOXcmmv" +
       "TWqOrjsle1e2rpYVjySA/b3Ho74rB3NAV3mR/oWL1os/AhwlwFEF2BYwPgCg" +
       "5Bov2aM+ffZv//hP7nnqGyehnQ503nJlrSPnAQedA56uB3OAXYn3809uvTm+" +
       "DRQXc1Wh65TfOsh9+a9TQMDLN8eaTpaTHIbrff/BWMo7//7frzNCjjI32IqP" +
       "jZeQFz56P/7m7+XjD8M9G/1Qcj0og/ztcGzp0/a/7jx25k93oLMSdFHdSw4F" +
       "2YqyIJJAQhTsZ4wggbym/9rkZruTXzmAsweOQ82RaY8DzeFmAOoZdVY/fwxb" +
       "XpVZ+U3gQfawBTmOLSegvPJkPuTRvLyUFT+zDeWs+rM508shdFrNNpuc5rUh" +
       "VLhu/8nWTI7DXTXbfXZpIJ+2twfhGdUWxrKynBXYdvFrN3WUK/m0yQmAJ6dL" +
       "u+huIfvdu7GgJ3NBAfAEea4MRhimI1v7kt+7sNRL+1AjgNwZeMqlhYXu63Ix" +
       "d/JsTXa3CecxWS//r2UFTnzHITPSBbnre//hA19//+u+DTytD51eZ14AHOzI" +
       "jHSUpfO/+sIHH3zVc995b46jwPLCM49/75mM6/hWGmcFlRX0vqr3Z6qO8gSF" +
       "lIOQyuFO13JtbxlgrG/aYIdY7+WqyNN3fXv50e9+ZpuHHo+mY8T6e5579se7" +
       "73tu50j2/7rrEvCjY7ZvALnQr96zsA89eqtZ8hGdf/zc03/4qaffvZXqrmtz" +
       "2TZ4VfvMX/7X13c/8p2v3iBhOmW5P8HChncUupWgh+1/yOLUqCT8MCkZZZ2G" +
       "y+VuNxYJPp51u5w44NEZNShGU7dhV9FmwSgvZmGXLBMJSdJrCVH1BiI3knKU" +
       "auWoILfDwG1z/d5q4lpduD5f+pXCcKbQ2ooo2Qsl7K8Kw0lQ9HiJHuJRknRM" +
       "esXyKAUjIYwSZXMzXvUXAcogjAayVzZFVFSFK/LKH1LFdqVArDrjpt82jaGr" +
       "JSupw1ttYdKYMkR73RsXxRkLwzXGGbJER+wU9DhRsPKghJMN3OqMhXkcCosR" +
       "OV0W7OIcmw8UySzh3IQaqbEgcuHCcgV50/RXvVVQaLcbw+GiOWhJCxmr2cXO" +
       "aMTwLoFiBXcyj1tjc8yYGjd2mBrjcpJE1yS1PuP1+mruzK2OXVaowPS8hY5g" +
       "bcvp87w8mU7DbrTuORHVHRYHK3ZFt8kNTfa75QnuT4kw4KrtAeNVfThaEAWl" +
       "Y/vuoDqh6cImmKThnCaFjdYbuLJcptuwNRmFa91MV/iAqC3K7U5XJJw2ZTGd" +
       "Ec4lRU8c+bO113GjScJX4T4n1dQVV5pSvDKm1hW7OZY2xTBxbJaiGFobTZxR" +
       "nZAldeI1hVHHdSrVZnlUl7USLcIpthA7vMSYi3GzJBE4HpudhMcX/b5reQ15" +
       "OOo3ha6acnFjNks6cryCSwkZFueDYUAVmrBULlI9Qo2nCSzZkR/gTK8fScua" +
       "FXWCIalW9A1SnNiCFDcnuo4GM7cPN5YVvGM6GEHbhMsaJT60FyOwqa16Vjzk" +
       "O8Q4MDCsP514BUtrx+tuSyDjFMcm7ohcdRbkCGdnuuUSIzwsqm187Lq8RZcm" +
       "NdrH6osFtYzH8YZrqYHn4ivLjHBSJlyaXxBa3PNJLpluJowhFyhlkW4CRevi" +
       "A4yrexUzoNaoPxU66JTulJbm1J6NZxyehMDC6Awe1VXcpNrJoNCcLrspyutR" +
       "GdVriDbwZ5FSIiZmqW+onD1SljV9HNCJ1ongmjclUp4gVxbFsGif0Ya0nbIa" +
       "o9Jcf1GdD8uSRI2kNTluDKsNuIGn1V4vXTUtXPAHUZVkF8Nux2EJ1xukIDp6" +
       "G9nutyaY7NoTc01WMYGjEck022OiRkqlEt4sYkGRg4WBmCI13KSJtCl0uK7B" +
       "C2StgBpxd0Q1EIrgVjN5bc8So6PO67pltnhekvmUbc8cctKhCuLQLWkjGelz" +
       "XbPfJsrTYm+07lbVYD1S8VHFrU0kIo6w7rQ+0kd9bzBYMsul1qVjUopixyda" +
       "BYooDQhxXJCnceIg6xq7GTOr6rLW5ghiOGxjVd4ccGHkuaa07MFOtA6jcmVe" +
       "V7yYHk710K+4kxnsDOtjry1Wa8N+rA9EtYa7YsU1qGmn3mvFXXQxwzgs4Ypa" +
       "L26EZbHkunFfTaum2lQ9x2uWYKs5LFZUsgn3hvVAFpIy2vPlYp1xi8uk2Otb" +
       "dkCtNinWkGZyPEpq5RgN5rjqDNKhRbJju9Ufh2OrsBz0BiGP+s3ySms7JuUQ" +
       "A8l3Smq3L+NJydPIqtRW4II8GS8rMG3YVZroiQ152tMm3LKXVKcsVcbWs+7c" +
       "aTerdsk3vAo9YUkPnfpoiFXUAB37bjAJrGUNM2tDAWvgoiPw66ReccWGI6Rh" +
       "yLWWnTY7w3i51KwjcUXAyzPYoqy5yzGDkjKRN5sBb3Q1cUwVcUNr67W1WlyM" +
       "B9ZGjAQc46QKg84LibNGq+NyFek09OUytWUWt5A53YxaxVWSCm6FDIoJKw66" +
       "I27BrUVtA1MhKy6iyhINFjy+MWpqkykup01PxWou1e2KjTKKrkPRM+GuONTt" +
       "5aCajuR5rW5tJvoQafXjsWGg7TWXzEq9Pm73J36rrPXw8twJqn0+UpKmNFhi" +
       "uFpBmWYqxNxmElYGw8GETetuyemUIgPRB0PJ7kSdtqopQtioY2WjHlpoocZE" +
       "KBL6TBg7fZJlarDD9pt9EFuiEVF8oZ4Yix6LKJPKCq7PPJhIsOZMwR0UpzQx" +
       "YSfNCGuX1U4pqOjlWkynmt+x5rpYVrsFWcfN5byLlutTnXXnm4ZebaS10Waz" +
       "LnN6UhiV6qPOrNmyw64WsTPWaFgBQtFFX7FmU73U6zTDWJtOFRL4RNh07FAg" +
       "abg1ZZqxjyWJUiqkWEqmrDVJV5vIM9bseIPQxbWwasZszRtrUgoWI53xeLHC" +
       "+F0CI9A0WRlRu5xQxWVrnALZzcWQpyk8CIihDSOS1VLdMIjqqKIhss4ohY5e" +
       "m8zDxaIxI3Fy3ZuTA8QujzAERhSNTcupN2TG7hx1B24xmIk8ifhVejxEKw0N" +
       "HqBUL1GmktxXMJj0Cmg4xms1joHLM14MfTcVq5siNmhpob5mpHV9hK4Wtelw" +
       "LiRFIlU6BusWF3SgmAxXF1xmxBcF2oR1ESn2CysNnfUr5MzFbdiY9gabamlI" +
       "1hZ9v0jEFDyhGpSON+p9Leh6MsbO5621wgiksB6UzHTizw1r2qhX69MxErUd" +
       "wWqsGJe3p55da0w5mpBdM2VavcCR+aHNAPxvtgdLtB3rksDhhuWgI21a71Go" +
       "zvTZtbmyBb+5DFRqhgh8tVg1khrDclWvXrY21qA49BpezVbA6wOHaw7hRZ4j" +
       "IjTVXXgNRhFD2zdadseph6WZJvoGhcCwqiwlBtHtEjFb6ZNaIGsDbzlbuUYH" +
       "d+QlWa4QsCTimqqUpTmCpqKKUmipzHubODDA630TCZCkx00t0Vtim009WDXZ" +
       "TaoGEytobMo8wQd4bZZE8LTcVGuNUDSXBo6w6LJijlwnEo0iUWZTZTXGeuJw" +
       "UuqShcGkg2yshO96DUVGfKxBmEw0xATVb7YZz5tMRvxAoRxqIPfbPE0oc63W" +
       "6k8mElbxQ59yJXM+LIzVrlacLtV1e+PAWL20mRXh1iKK3Q1p99Ma3FKm9fVU" +
       "hdergcIX3F5vUII7ISfovLm0hjVtzTY5tCi2pw1dUtWR7khmt2BNO+zCIeE+" +
       "FXrwvCWgLrcajrmeUOCxwsaui70ytqmJFLskKrjUYqJKaZogsWbLEzp1DKyh" +
       "MOuS2rTTJsjfxh2iOB254x5e4BeJhBichRntSPI5pgZ8oVHS6l5xmW5ctMEN" +
       "I7o7YenqZkGBfaOgYe0Aj9araDpLm0On38drVXo0lwY1zkHNSVerE2iVZ4xY" +
       "iUWsvFBa2LIrwqu0ALb1csNPm65sElOh3sRam0ozWXgRhxWCjYJzZJUihuRs" +
       "2PCN+hqtrOS10xwjTduksTFW0VgkSarUPMEM1GxPrGphHDFapVgZYV4c1lJ1" +
       "ICYdBK5H6BoBryEBO7dLdLKxVzyTltmJTPODdgnEj+gyrRQxdcAdLnhyz+AD" +
       "F1sFlrcJKyrBL6pTRZQ3Jt8YOKLhdDYc2MnsRgwPuFWkxh7WTXQWWcitHohT" +
       "Hl1MMEuukKZVWSRcJBtMp8AXykqNM4yKaKd1yhcwujZKV/YqRBebxiCgljVO" +
       "IK1Sa0DyFLKgaV4I+utej2snhSjR1A4yXGJ1E2tYbbReLIRla9WrWXGt1J4X" +
       "1hvRBqkCHqMzscXJUcRHLQkDLwqc18bkOVXbuGq9yCmbyWBRlObTFcl2dFGw" +
       "63VCM5Oatams2pWeUK+vRdGt6JGhtyXVmfAC2lh3tdWyKyRgA2736WCQLpWg" +
       "qgtCVFOCBPYduVNpwPAKjUQarjgVxqnbfhCrfb3AzEJx4+gOjaKVSoEWAIou" +
       "0SU3b7HWUioTkrPQNnwvDRfNSbdFD1mkTyplQxRWfMkvlJFaX6n3XJn0x1UM" +
       "BrLB9UZLSRKJikuTijFrClxkjliyjpRbsKWMjM28aXUXU1+wYnUyHaqdFVqt" +
       "OFSp3vEpc8asO4KtLabSqLESQHY2jeNk1BiqhK32CbDkIT3SlmMx2jBwoxQ5" +
       "WcQObbzJwL1mUa6DlA0kiW2NTrApHZdtbkXEqY7jBh71Rl145ItwXyuu01k5" +
       "FYQ53seJGYZlr476K3t7vzM/qDi4JgMv7VkH+wreWrddj2bF4wfnQPnnzP6V" +
       "yv73kXOgI+dwJ/YPRV5/swuGtu+7/sGdaPbi/uDNLsvyl/aPv/O55zXmE8Wd" +
       "vePOp0LoXOh6P2fpa906MvNJwOmJmx9QUPld4eEx3Jff+c/3j988f+oVXDQ8" +
       "fEzO4yx/m3rhq8Tr1d/YgU4eHMpdd4t57aAr1x7Fnff1MPKd8TUHcg8eLMRd" +
       "+4f9lb2FqNz4sP9lT+NucZr89C363p4VSQjdPtND0lVli94TnT30rs3LnYkc" +
       "ZZo3RAf6PZA1lsCD7emH/d/od3LPQfZc8/Gbueb2lmvvqnyf+u6MOi6ru5pr" +
       "7+5dh+U651P92i3M9f6s+JUQukf1dTnUezie36yNwMx6+3AC5GWOQm84Lrf1" +
       "u34CW9+bNV4Cz7N7tn72Fdh6J4TOer65BlrlKHRDq+9sSbOfv54Vz+ZUH72F" +
       "wZ7Pig+F+an3WvfDHliIvf9NvOUIcl0NoZOmc8QOH34ldgD++8CtLjmzW5r7" +
       "rvuTxfaPAepnn79w273P83+V3/MdXN6fI6HbjMiyjh6qH6mf8XzdMHMNz22P" +
       "2L3861MhdO9NXDGEzmwrufif3NL/TghdPE4fQqfz76N0nw2h84d0gNW2cpTk" +
       "d4EJAUlW/YK374iXbxYXmBKEvqyGwGxbGyUnjgDvnmvlK3HXy63EwZCj94OZ" +
       "v+f/ftkH1mj7/5er6uee79Nve6n2ie39pGrJaZpxuY2Ezm6vSg/A+dGbctvn" +
       "daZ7+Ud3fP7c4/sbyR1bgQ/d/IhsD9/4ArBte2F+ZZf+wb2/98ZPPv+t/Lz9" +
       "fwDcN3WbliQAAA==");
}
