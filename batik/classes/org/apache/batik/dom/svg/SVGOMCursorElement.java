package org.apache.batik.dom.svg;
public class SVGOMCursorElement extends org.apache.batik.dom.svg.SVGOMURIReferenceElement implements org.w3c.dom.svg.SVGCursorElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI,
                                               "xlink",
                                               "type",
                                               "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static org.apache.batik.util.DoublyIndexedTable
      xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t =
               new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMURIReferenceElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMCursorElement() { super(
                                       );
    }
    public SVGOMCursorElement(java.lang.String prefix,
                              org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_CURSOR_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_CURSOR_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_CURSOR_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMCursorElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7e9Asx1XffFfS1cOSrp6WLFtPX2OkMXd2Z/aJZOzZnd2d" +
       "2Xns7Lx2dxJLnp3Hzvs9+yIK4MLYFYjjYBlMFdZfpkwcg8iDch5FLCoVBGXi" +
       "CgRCSCrYSSUFCbgKVSokhZI4Pfu9v3vvJ8lX2a+6v9nu093nd87p06d7er/6" +
       "HeiWLIXgOPI3Cz/Kr5jr/Irr16/km9jMrgyZOq+lmWl0fS3LJFD2gv7Ur1z6" +
       "izc+a99zAbqoQvdrYRjlWu5EYSaYWeQvTYOBLh2X9nwzyHLoHsbVlhpS5I6P" +
       "ME6WP8tA7zrRNIcuM4csIIAFBLCA7FhA8GMq0OguMyyCbtlCC/Msgf46tMdA" +
       "F2O9ZC+HnjzdSaylWnDQDb9DAHq4rfyuAFC7xusUeuII+z7mqwB/HkZe+tnn" +
       "7/n7N0GXVOiSE4olOzpgIgeDqNCdgRnMzTTDDcM0VOje0DQN0UwdzXe2O75V" +
       "6L7MWYRaXqTmkZDKwiI2092Yx5K7Uy+xpYWeR+kRPMsxfePw2y2Wry0A1ncf" +
       "Y91H2C/LAcA7HMBYamm6edjkZs8JjRx6/GyLI4yXaUAAmt4amLkdHQ11c6iB" +
       "Aui+fd35WrhAxDx1wgUgvSUqwCg59Mh1Oy1lHWu6py3MF3Lo4bN0/H4VoLp9" +
       "J4iySQ49eJZs1xPQ0iNntHRCP9/hnvvMD4dkeGHHs2Hqfsn/baDRY2caCaZl" +
       "pmaom/sN73yG+Rnt3b/26QsQBIgfPEO8T/O1v/b6Rz/02Ku/uU/z3mvQjOau" +
       "qecv6F+a3/077+s+3b6pZOO2OMqcUvmnkO/Mnz+oeXYdg5n37qMey8orh5Wv" +
       "Cr8x+9GvmH96AbqDgi7qkV8EwI7u1aMgdnwzHZihmWq5aVDQ7WZodHf1FHQr" +
       "eGac0NwvHVlWZuYUdLO/K7oY7b4DEVmgi1JEt4JnJ7Siw+dYy+3d8zqGIOhW" +
       "kKDHQXoa2v98sMxy6HnEjgIT0XQtdMII4dOoxJ8hZpjPgWxtZA6s3kOyqEiB" +
       "CSJRukA0YAe2eVBhRAGSLYEpKYMR2y3SLEpLJwGaXyntLP7/PsK6xHjPam8P" +
       "iP99Zye/D+YNGfmGmb6gv1R0eq//8gvfuHA0GQ6kk0MwGPTK/qBXdoNeAYNe" +
       "AYNeuXpQaG9vN9YD5eD7agZK8sB0B47wzqfFjw0//umnbgL2Fa9uBhK+AEiR" +
       "6/vj7rGDoHZuUAdWCr36hdWPKT9SuQBdOO1YS4ZB0R1lc750h0du7/LZCXWt" +
       "fi996k/+4pWfeTE6nlqnPPXBjL+6ZTljnzor2jTSTQP4wOPun3lC+9UXfu3F" +
       "yxegm4EbAK4v14CpAq/y2NkxTs3cZw+9YInlFgDYitJA88uqQ9d1R26n0eq4" +
       "ZKfzu3fP9wIZ312a8hMgPX9g27v/Ze39cZk/sG8jpdLOoNh52Q+L8Rf/7Tf/" +
       "K7YT96FDvnRiiRPN/NkTTqDs7NJuut97bANSapqA7j98gf/c57/zqb+yMwBA" +
       "8f5rDXi5zLtg8gMVAjF/8jeTP/zWH33p9y4cGc1eDt0ep1EO5olprI9wllXQ" +
       "XefgBAN+3zFLwI/4oIfScC7LYRAZjuVoc98sDfV/X/pA9Vf/7DP37JuCD0oO" +
       "LelDb97Bcfl7OtCPfuP5//nYrps9vVzHjsV2TLbvHO8/7hlPU21T8rH+sd99" +
       "9Ode074I3CxwbZmzNXfeCtqJAdrpDdnhf2aXXzlTVy2zx7OT9n96ip2IN17Q" +
       "P/t7f36X8uf/7PUdt6cDlpPqZrX42X0LK7Mn1qD7h85OdlLLbEBXe5X7q/f4" +
       "r74BelRBjzpwYNkoBe5mfco4DqhvufXf/fo/f/fHf+cm6EIfusOPNKOv7eYZ" +
       "dDswcDOzgadaxx/56L5yV7eB7J4dVOgq8LuCR44s411l4aMgWQeWYV17BpT5" +
       "k7v8cpl98NDaLsbF3Hf0M6Z2xzkdnlHKhQNnV35/EASIO+xljHFlP8Y4rPjA" +
       "NT0tPgcuB4iCiPSi9LE7bj96jt77ZdbeVaFl9oP7nNffkuz2aR/efbsNKPfp" +
       "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" +
       "MHMm0jWfOzBX/BjfazeAr3xjDz0J0k8d");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4Pupdx7fH5xT94dl9rvARgG+6aHbevIabuv0S7dj8P/6nQD/uQPwn3vnwf+X" +
       "c+r+uMy+vQ9+Vj7/+2Nc//EGcJX2Cv0gSF88wPXFdx7X6+fU/fcy+7Mceh/A" +
       "1Xuz14BPnaPsg3d/x1L5zg1I5T1l4YdA+vKBVL78zkvlu9ev29t18Zc5dD+Q" +
       "yqEQ+ub+Ld5DYTx6DWHsX18pryody+GNG5VDWf/KgRxeecflsHfXOXWXyuy2" +
       "HHrwhBxKKwmzg/V/76YjoHu33yjQZ0D62gHQr73zQN9zTt17y+wBEBECoOIm" +
       "y82A0cJFoS3MMyAfvAGQ95eF5a3arx+A/Po7A3LvmADfofnAOUg/WGZPgFXK" +
       "1rJTqjwbitw6PzOj9568AezvLwtLP/faAfbX3i72Nw3I9mrn1DXKDMmhh4CC" +
       "r3dXZ3YMtXKjan4EpG8eQP3mOw/1nOtue50yexYoMDRXXGSYhw7rnpMO66hi" +
       "B/e5G4BbLspQG6TfP4D7++88XO6cOr7MKBBiAs2eveB0dGlpfox1+LZu/+XQ" +
       "fVff6i7vpz581U9H9n/uoP/yy5due+hl+Q92F5uPfpJwOwPdZhW+f/JK3Inn" +
       "i3FqWs5ODrfvX5CLd+AmANf17t7k0E0g33lhZZ9azaEHrkUNKEF+kvJjB+Zw" +
       "kjKHbtn9P0n38Ry645guhy7uP5wk0UHvgKR8NOJDW6uef2FIFqijW92H29v9" +
       "nfDDJ41st37e92b6Ompy8gJ1uavd/QbocAda7P8K6AX9lZeH3A+/3viF/Qvc" +
       "uq9tt2UvtzHQrft3yXedlrvYJ6/b22FfF8mn37j7V27/wOGO++59ho8N/gRv" +
       "j1/7qnQviPPd5ebtP3roHz735Zf/aHdl6P8B5jxk2Jw1AAA=");
}
