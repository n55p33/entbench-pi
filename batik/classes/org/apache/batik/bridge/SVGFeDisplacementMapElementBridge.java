package org.apache.batik.bridge;
public class SVGFeDisplacementMapElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeDisplacementMapElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DISPLACEMENT_MAP_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float scale =
          convertNumber(
            filterElement,
            SVG_SCALE_ATTRIBUTE,
            0,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_X_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_Y_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            pad);
        srcs.
          add(
            in2);
        org.apache.batik.ext.awt.image.renderable.Filter displacementMap =
          new org.apache.batik.ext.awt.image.renderable.DisplacementMapRable8Bit(
          srcs,
          scale,
          xChannelSelector,
          yChannelSelector);
        handleColorInterpolationFilters(
          displacementMap,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          displacementMap,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.ARGBChannel convertChannelSelector(org.w3c.dom.Element filterElement,
                                                                                       java.lang.String attrName,
                                                                                       org.apache.batik.ext.awt.image.ARGBChannel defaultChannel,
                                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultChannel;
        }
        if (SVG_A_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     A;
        }
        if (SVG_R_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     R;
        }
        if (SVG_G_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     G;
        }
        if (SVG_B_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     B;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { attrName,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxkfn9/vB2DeBowBYcgdNKENNXnYxjaGs7naxGqP" +
       "xzG3O3e3eG932Z2zz6ZJSJQqtFUQIoSQSlhBcgptaYiqRm2ah1xFykNJK5Gi" +
       "pmkUipT+kbRFCYqa/kFf38zu3u7t3dmibWpp59Yz33wz3/f95vd9sxevo1JD" +
       "Ry1EoX46oRHD36PQENYNInbL2DD2QF9EeLIYf3bgo8GtPlQWRnUJbAwI2CC9" +
       "EpFFI4yWS4pBsSIQY5AQkc0I6cQg+himkqqE0QLJ6E9qsiRIdEAVCRMYwXoQ" +
       "NWJKdSmaoqTfUkDR8iDsJMB3Euj0DncEUY2gahOO+CKXeLdrhEkmnbUMihqC" +
       "h/AYDqSoJAeCkkE70jraoKnyRFxWqZ+kqf+QvMVywc7glhwXtD5X//nNE4kG" +
       "7oJ5WFFUys0zhoihymNEDKJ6p7dHJknjMHoAFQdRtUuYoragvWgAFg3Aora1" +
       "jhTsvpYoqWS3ys2htqYyTWAbomhVthIN6zhpqQnxPYOGCmrZzieDtSsz1ppW" +
       "5pj4xIbAqScPNPykGNWHUb2kDLPtCLAJCouEwaEkGSW60SmKRAyjRgWCPUx0" +
       "CcvSpBXpJkOKK5imIPy2W1hnSiM6X9PxFcQRbNNTAlX1jHkxDijrv9KYjONg" +
       "a7Njq2lhL+sHA6sk2Jgew4A7a0rJqKSIFK3wzsjY2LYLBGBqeZLQhJpZqkTB" +
       "0IGaTIjIWIkHhgF6ShxES1UAoE7RkoJKma81LIziOIkwRHrkQuYQSFVyR7Ap" +
       "FC3winFNEKUlnii54nN9cNvxI8oOxYeKYM8iEWS2/2qY1OKZNERiRCdwDsyJ" +
       "Ne3B07j55WM+hEB4gUfYlPnZN2/cu7Fl5g1TZmkemd3RQ0SgEWE6Wnd5Wff6" +
       "rcVsGxWaakgs+FmW81MWskY60howTHNGIxv024MzQ6994+gPyZ99qKoflQmq" +
       "nEoCjhoFNalJMtH7iEJ0TInYjyqJInbz8X5UDu9BSSFm7+5YzCC0H5XIvKtM" +
       "5f+Di2KggrmoCt4lJaba7xqmCf6e1hBC5fCgGnjWI/OP/1IkBxJqkgSwgBVJ" +
       "UQMhXWX2GwFgnCj4NhGIAupHA4aa0gGCAVWPBzDgIEGsgaguiXESGB7p6yXb" +
       "JUOTAalJmDyANUYP8NbFJfwMddr/eb00s3/eeFERhGaZlxjYzB2qLBI9IpxK" +
       "dfXceDbylgk6dlAsz1G0FbbgN7fg51vwm1vwz7kFVFTEV57PtmICAsI5CsQA" +
       "zFyzfnj/zoPHWosBidp4CcSCibZmZahuhz1syo8Il5pqJ1dd3fyqD5UEURMW" +
       "aArLLOF06nGgMmHUOu01UchdTgpZ6UohLPfpqkBEYLBCqcTSUqGOEZ31UzTf" +
       "pcFOcOwoBwqnl7z7RzNnxh8aeXCTD/myswZbshQIj00PMa7PcHqbly3y6a1/" +
       "9KPPL52+X3V4IysN2dkzZyazodWLDa97IkL7Svx85OX727jbK4HXKYZzCJTZ" +
       "4l0ji5Y6bIpntlSAwTFVT2KZDdk+rqIJXR13ejhoG/n7fIBFNTunG+HZZB1c" +
       "/stGmzXWLjRBznDmsYKnkLuGtbO/+/XHt3N329mm3lUmDBPa4WI4pqyJc1mj" +
       "A9s9OiEg98GZ0ONPXH90L8csSKzOt2Aba7uB2SCE4OZvvXH4vT9cnb7ic3BO" +
       "IcWnolAppTNGsn5UNYuRsNpaZz/AkDKwBkNN230K4FOKSTgqE3aw/l6/ZvPz" +
       "fzneYOJAhh4bRhvnVuD0L+5CR9868LcWrqZIYBna8ZkjZtL+PEdzp67jCbaP" +
       "9EPvLH/qdXwWEgiQtiFNEs7DiPsA8aBt4fZv4u0dnrGvsGaN4QZ/9vlyVVIR" +
       "4cSVT2tHPn3lBt9tdinmjjUwVIcJL9asTYP6hV5y2oGNBMjdMTO4r0GeuQka" +
       "w6BRADI2dutAluksZFjSpeW//+WrzQcvFyNfL6qSVSz2Yn7IUCWgmxgJ4Nm0" +
       "ds+9ZnDHK6Bp4KaiHONzOpiDV+QPXU9So9zZkz9f+NNt56eucpRppo6lboXr" +
       "WLMhgzf+V+bNhm68ZWnQ0fJCBQsvtqYfPjUl7n5ms1lWNGUXAT1Q4/74t/94" +
       "23/m2pt58kslVbXbZDJGZNeaxWzJrFwwwGs5h48+qDv54Qtt8a5bSQOsr2UO" +
       "omf/rwAj2gvTuncrrz/8pyV77k4cvAVGX+Fxp1flDwYuvtm3Vjjp44WrSeY5" +
       "BW/2pA63Y2FRnUCFrjAzWU8th/3qDACaWGBb4NliAWBLflbNg50MVxWaOsup" +
       "3jPL2AhrdlNUE4eyThWwPAjWcMlFcLHjB4AV7X6zaOcDd7ImZCK84z88Xayj" +
       "U+P9u3Lds8uycdetu6fQVI8LyvlGym1D1xQqt8yayrqn2dLzmPT47YJfVJN+" +
       "q/hiQzFbYFWOuvgY9ffpWEtIgjEIgLclN+VIMuDjceqXknCz8UNKB/ZjScLf" +
       "K8lwW7InLuahYYJxArsYAnKCMMnkS9uzDzE7ncOpqEGH8Dinj4iwb11Dc9vW" +
       "z1pN3mjJI+u6GB1/8Rfh8LoGwRRuzac4+0J04XyF8H7ytT+aExbnmWDKLbgQ" +
       "eGzk3UNv8/NbwQgjc2pcZAHE4qpPGjLxrmPhbYTnmhVv/kvRvv+y0IdpcNuX" +
       "koD1wB4pSUQrvPZF4gvVzzNjFv86QfvRqNz5yZ3fv8t066oCPOnIv/C1a5fP" +
       "Tl66aHI/cy9FGwp9H8n9KMPq0zWz1NgOQP7a99WZjz8c2e+zCKWONUbaxmmt" +
       "k0MhY7POI5lDWJS5gczPhompefu361860VTcC8mmH1WkFOlwivSL2YRbbqSi" +
       "Ltw4nwEc+rVA8y/4K4Lnn+xhYGEdJmiauq0r8crMnRjSORunqKgdXrkeYRYW" +
       "fYQ1B4BFBZ3AdPOosr5DDmNGvgDG5FVFOzznrGNwbhbG5G07a27jSn1QBmi6" +
       "SgHARITy2ODfpDzlMXt52lL+9OycWsK1lnAmZM3XbQy0z0FynUN9Xd0JSOGE" +
       "f3UR+aZPzuLu06z5DlTHcCOCCoJak4cJq9FU7vjHHcd/93/h+DSw+px3b1Y0" +
       "Lsr5FGh+vhKenaqvWDh137u8dsp8YqoB8oulZNmFaTe+yzSdxCRudI1ZQ2v8" +
       "Z4qihQVyFkTSfOGmnDXlz0Ey98pTVMp/3XLTFFU5cqDKfHGLnKeoGETY6wXN" +
       "DvE9hRJoJxC+DoUi8x0/FSEd2I9KYyTLc+mi3OqZB2/BXMFzlcurswiLf7m1" +
       "SSUVsnjx0tTOwSM3vvyMeTMVZDw5ybRUA5WYl+RMtbiqoDZbV9mO9Tfrnqtc" +
       "Y1Nfo7lh58gtdWG2E5hOYwBZ4rm2GW2Z29t709te+dWxsneAtPeiIgyVxl7X" +
       "d1PzIyHc/VKQ4fcGcykTKmt+n+xY/72JuzfGPnmfX0wsil1WWD4iXDm//zcn" +
       "F03DvbO6H5XC3YKkw6hKMrZPKFBZjOlhVCsZPWnYImiRsJzFx3UMy5iVh9wv" +
       "ljtrM73suwZFrTkfb/N8DYJL3DjRu9SUIlqMXu30ZH1StgvulKZ5Jjg9rsrh" +
       "AdYcTZt8XxwJDmiazf+lJzV+xh/05iXeyWe/yF9Z89K/AYbE2XDVGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QUz/8DW//6ZPP/vt/FLifwFEI+wbKCUAAA==");
}
