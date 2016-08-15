package org.apache.batik.dom.svg;
public abstract class SVGGraphicsElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.apache.batik.dom.svg.SVGMotionAnimatableElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected java.awt.geom.AffineTransform motionTransform;
    protected SVGGraphicsElement() { super(); }
    protected SVGGraphicsElement(java.lang.String prefix,
                                 org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { transform =
                                                createLiveAnimatedTransformList(
                                                  null,
                                                  SVG_TRANSFORM_ATTRIBUTE,
                                                  "");
                                              externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
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
    public java.awt.geom.AffineTransform getMotionTransform() {
        return motionTransform;
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        if (type.
              equals(
                "motion")) {
            if (motionTransform ==
                  null) {
                motionTransform =
                  new java.awt.geom.AffineTransform(
                    );
            }
            if (val ==
                  null) {
                motionTransform.
                  setToIdentity(
                    );
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue p =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    val;
                motionTransform.
                  setToTranslation(
                    p.
                      getX(
                        ),
                    p.
                      getY(
                        ));
                motionTransform.
                  rotate(
                    p.
                      getAngle(
                        ));
            }
            org.apache.batik.dom.svg.SVGOMDocument d =
              (org.apache.batik.dom.svg.SVGOMDocument)
                ownerDocument;
            d.
              getAnimatedAttributeListener(
                ).
              otherAnimationChanged(
                this,
                type);
        }
        else {
            super.
              updateOtherValue(
                type,
                val);
        }
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
      ("H4sIAAAAAAAAALV7C9DsZnne/sf3Cz6+YDDGNhhMAhYcaVd7jQEjaVfai6SV" +
       "tFrtrpJgtJJW0uq6uqy0ok4TSgq5DDCNScgMeKYdMy3UXCZNhmTStKYdQi60" +
       "M7RJS9NpnHY6TShlJp5p0lKapp9297+ec37bOYd/Rt+v/e7P+77fo/e7Pf/d" +
       "0k1RWIIC39kYjh9f0rP40tKpXYo3gR5d6tM1TgkjXSMcJYpEEPeU+pYvX/zL" +
       "73/CvPtC6Wa5dJ/ieX6sxJbvRYIe+c5a1+jSxePYjqO7UVy6m14qawVOYsuB" +
       "aSuKn6BLd5woGpceow+7AIMuwKAL8LYLMHacCxR6je4lLlGUULw4WpV+onRA" +
       "l24O1KJ7cenR05UESqi4+2q4LQJQw63FbwmA2hbOwtKbj7DvMF8G+JMQ/Mwv" +
       "vf/uX7mhdFEuXbS8UdEdFXQiBo3IpTtd3Z3rYYRpmq7JpXs8XddGemgpjpVv" +
       "+y2X7o0sw1PiJNSPhFREJoEebts8ltydaoEtTNTYD4/gLSzd0Q5/3bRwFANg" +
       "fd0x1h1CsogHAG+3QMfChaLqh0VutC1Pi0tvOlviCONjA5ABFL3F1WPTP2rq" +
       "Rk8BEaV7d7pzFM+AR3FoeQbIepOfgFbi0oNXrbSQdaCotmLoT8WlB87m43ZJ" +
       "INdtW0EUReLS/WezbWsCWnrwjJZO6Oe77Ls/9kGv613Y9lnTVafo/62g0CNn" +
       "Cgn6Qg91T9V3Be98nP5F5XW/9dELpRLIfP+ZzLs8X/lbL73vnY+88Du7PG+8" +
       "Qp7hfKmr8VPqc/O7vvkQ8Y7WDUU3bg38yCqUfwr51vy5fcoTWQBG3uuOaiwS" +
       "Lx0mviD89uwnP69/50Lp9l7pZtV3EhfY0T2q7waWo4eU7umhEutar3Sb7mnE" +
       "Nr1XugW805an72KHi0Wkx73Sjc426mZ/+xuIaAGqKER0C3i3vIV/+B4osbl9" +
       "z4JSqXQ3eErvAs+l0u7vnUUQl94Pm76rw4qqeJbnw1zoF/gjWPfiOZCtCc+B" +
       "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" +
       "IPamZmW4Yvu574+ZmmQQJl/O6zQHdxpD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "0z4AAA==");
}
