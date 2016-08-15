package org.apache.batik.bridge;
public class UserAgentAdapter implements org.apache.batik.bridge.UserAgent {
    protected java.util.Set FEATURES = new java.util.HashSet();
    protected java.util.Set extensions = new java.util.HashSet();
    protected org.apache.batik.bridge.BridgeContext ctx;
    public void setBridgeContext(org.apache.batik.bridge.BridgeContext ctx) {
        this.
          ctx =
          ctx;
    }
    public void addStdFeatures() { org.apache.batik.util.SVGFeatureStrings.
                                     addSupportedFeatureStrings(
                                       FEATURES); }
    public java.awt.geom.Dimension2D getViewportSize() { return new java.awt.Dimension(
                                                           1,
                                                           1); }
    public void displayMessage(java.lang.String message) {  }
    public void displayError(java.lang.String message) { displayMessage(
                                                           message);
    }
    public void displayError(java.lang.Exception e) { displayError(
                                                        e.
                                                          getMessage(
                                                            )); }
    public void showAlert(java.lang.String message) {  }
    public java.lang.String showPrompt(java.lang.String message) {
        return null;
    }
    public java.lang.String showPrompt(java.lang.String message, java.lang.String defaultValue) {
        return null;
    }
    public boolean showConfirm(java.lang.String message) {
        return false;
    }
    public float getPixelUnitToMillimeter() { return 0.26458332F;
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           ); }
    public java.lang.String getDefaultFontFamily() { return "Arial, Helvetica, sans-serif";
    }
    public float getMediumFontSize() { return 9.0F *
                                         25.4F /
                                         (72.0F *
                                            getPixelUnitToMillimeter(
                                              ));
    }
    public float getLighterFontWeight(float f) { return getStandardLighterFontWeight(
                                                          f);
    }
    public float getBolderFontWeight(float f) {
        return getStandardBolderFontWeight(
                 f);
    }
    public java.lang.String getLanguages() {
        return "en";
    }
    public java.lang.String getMedia() { return "all";
    }
    public java.lang.String getAlternateStyleSheet() {
        return null;
    }
    public java.lang.String getUserStyleSheetURI() {
        return null;
    }
    public java.lang.String getXMLParserClassName() {
        return org.apache.batik.util.XMLResourceDescriptor.
          getXMLParserClassName(
            );
    }
    public boolean isXMLParserValidating() {
        return false;
    }
    public org.apache.batik.gvt.event.EventDispatcher getEventDispatcher() {
        return null;
    }
    public void openLink(org.w3c.dom.svg.SVGAElement elt) {
        
    }
    public void setSVGCursor(java.awt.Cursor cursor) {
        
    }
    public void setTextSelection(org.apache.batik.gvt.text.Mark start,
                                 org.apache.batik.gvt.text.Mark end) {
        
    }
    public void deselectAll() {  }
    public void runThread(java.lang.Thread t) {
        
    }
    public java.awt.geom.AffineTransform getTransform() {
        return null;
    }
    public void setTransform(java.awt.geom.AffineTransform at) {
        
    }
    public java.awt.Point getClientAreaLocationOnScreen() {
        return new java.awt.Point(
          );
    }
    public boolean hasFeature(java.lang.String s) {
        return FEATURES.
          contains(
            s);
    }
    public boolean supportExtension(java.lang.String s) {
        return extensions.
          contains(
            s);
    }
    public void registerExtension(org.apache.batik.bridge.BridgeExtension ext) {
        java.util.Iterator i =
          ext.
          getImplementedExtensions(
            );
        while (i.
                 hasNext(
                   ))
            extensions.
              add(
                i.
                  next(
                    ));
    }
    public void handleElement(org.w3c.dom.Element elt,
                              java.lang.Object data) {
        
    }
    public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                    org.apache.batik.util.ParsedURL scriptURL,
                                                                    org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.DefaultScriptSecurity(
          scriptType,
          scriptURL,
          docURL);
    }
    public void checkLoadScript(java.lang.String scriptType,
                                org.apache.batik.util.ParsedURL scriptURL,
                                org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ScriptSecurity s =
          getScriptSecurity(
            scriptType,
            scriptURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadScript(
                );
        }
    }
    public org.apache.batik.bridge.ExternalResourceSecurity getExternalResourceSecurity(org.apache.batik.util.ParsedURL resourceURL,
                                                                                        org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.RelaxedExternalResourceSecurity(
          resourceURL,
          docURL);
    }
    public void checkLoadExternalResource(org.apache.batik.util.ParsedURL resourceURL,
                                          org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ExternalResourceSecurity s =
          getExternalResourceSecurity(
            resourceURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadExternalResource(
                );
        }
    }
    public static float getStandardLighterFontWeight(float f) {
        int weight =
          (int)
            ((f +
                50) /
               100) *
          100;
        switch (weight) {
            case 100:
                return 100;
            case 200:
                return 100;
            case 300:
                return 200;
            case 400:
                return 300;
            case 500:
                return 400;
            case 600:
                return 400;
            case 700:
                return 400;
            case 800:
                return 400;
            case 900:
                return 400;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Bad Font Weight: " +
                  f);
        }
    }
    public static float getStandardBolderFontWeight(float f) {
        int weight =
          (int)
            ((f +
                50) /
               100) *
          100;
        switch (weight) {
            case 100:
                return 600;
            case 200:
                return 600;
            case 300:
                return 600;
            case 400:
                return 600;
            case 500:
                return 600;
            case 600:
                return 700;
            case 700:
                return 800;
            case 800:
                return 900;
            case 900:
                return 900;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Bad Font Weight: " +
                  f);
        }
    }
    public org.w3c.dom.svg.SVGDocument getBrokenLinkDocument(org.w3c.dom.Element e,
                                                             java.lang.String url,
                                                             java.lang.String message) {
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          org.apache.batik.bridge.ErrorConstants.
            ERR_URI_IMAGE_BROKEN,
          new java.lang.Object[] { url,
          message });
    }
    public UserAgentAdapter() { super(); }
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
      ("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" +
       "oNGboVItCIYDmmlyk4rFCb01p6+lNEhw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
