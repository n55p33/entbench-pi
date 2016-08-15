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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W2qzabWmWgxH5UEgsXUwXs0H1bzBCFCv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ySMQqi0rhjkPWECHxdbdx17d7uk9203ho4tDf4Pt4PU5JzubpHSrtj/wOz7F" +
       "3v5dLO1voBz+P7EPf+LQ7uAVHYGw26343UFBcZKzv6lRbLE+fLWLRtvt1ec+" +
       "9MyzBv+Z6oX9YePPFqcvQfhO11yZ7olm3A9KeuLqW8ns9p7V8QHe1z703x4c" +
       "vWf+/ldxf+PRM+08W+Rn2ed/l/gB/e9eKN1wdJx32Q2w05mePH2Id3tkJmnk" +
       "j04d5T18+nSkApy114p19nTk2CjOPRo55yz3s+fE/aPCey4pvdH27WR7285E" +
       "XZexVyaaJJE9TRMz3mb86RMW+TNJ6cZVYBvHpvqZV3M8vA345SMR3FkEloEL" +
       "9iIIXo0IktItYWSvtMR8WTn8xjlxv1l4/zgpPXAsh9NCKOI/fwz4V68B8GNF" +
       "YBu4fA84v/46/+o5cV8rvBcAVstMzh7fHh3JysdYv3INWF9XBELA/dQe60+9" +
       "Wqybl8X6jXPi/k3hfT0pvQFg5UwtMuNEts0sDKJkT1eHVPdgQXUZop9kuJNJ" +
       "tqL4l9cqiqKr//xeFD9//UXx4jlx/6nw/ggABaLAtSiZXy6LIsUfHqP9D9eA" +
       "9r4i8EHgntmjfeb6o/32OXHfKbz/CtgBoMWwYH2o5tdfQc3D4mLkEeo/vQbU" +
       "25sZbwTuU3vUn7r+qL97Ttz3Cu9/JqWbAerOiD0E/YYrgGY1QG3rY9h/ca2w" +
       "C1p7bg/7uesO++CWc+JuK7wLSelOAFvUI9P0Afgi4V8d4Tu44VrxPQHc83t8" +
       "z18ffAfHCf5wC+S+Kyc41ONDV+KotW6GBXVvC7i/8O5KSvfvuH13/WEUnOjf" +
       "J0Ry8RpE8ngRWLDZl/ci+fL1V/lj58S9pfAe2qn8stsgb7uCnK54XedYFg9f" +
       "gyweKQJ/CLiv7GXxlesvi3OuYx4U1zEPngDmAWTRe7l7P28+Rzb7yz7HUilf" +
       "g1TuLQIfAu739lL5vesvlXefE1cspw5aSel2IJUxyxSXYIpk7z1G174GdHcU" +
       "gT8I3Df26L5x3SnhvVsY/XMg0oXXBRDjUxCP56kHvWtV4MPAfXMP8ZvXX4HS" +
       "OXFK4QlJ6Y6dAmOwDDXPaHBwrRp8O3Av7uG9+H3SoHYOxuLS2MGPAozxaYwn" +
       "VPhj14DxDUVgsdD/1h7jt66/Cr1z4opXMQfzpHQfUOEhEeHm7hHXISE9fAVC" +
       "2t1pPs3Q9rXKoYh/aS+Hl66/HD5wTtzThbfaDcuHciiY2o/3+xMHy2Og2bUC" +
       "LWYq390D/e71B/rhc+J+pvA+lJTuKWZimzgxPQaQUqpZ5hmQf/ta1xaPgvYe" +
       "7PLu/n8feu4vnIP0E4X3UTABmWvxKVWe3Sq5ZXp2VP3YNWAvFhfFg7KDO/bY" +
       "77j+Cv7758Q9V3ifTkr3AgWzp+/iFslPaPjZa+VmDDT4tXuUr70+KC8c75K+" +
       "95B/3nHZHqcGpkOXtldoi5csh9ub25v+Wxl84Rz5/ErhfTYp3Z2GBphS8WCZ" +
       "HW1zLk+z+ude1YMKIO/Ln8QVj3seuOzd7e6tqP6FZy/e+vpnpX+3fRV29J7z" +
       "NqZ06yx13ZOvDE583xxG5szeSu623ZuDcAvqN5LSA1fbCU5KNwB/y2G/vkv9" +
       "T5LSa6+UGqQE/smU/wzI6WzKpHTT9v/JdP8cTHGO04Hl7e7jZJKvgtJBkuLz" +
       "t8ND1Z77wFBMNu7JbevdKuuBkwa5XRjf+3KaOspy8t1ZsVu9fTp9uLOc7h5P" +
       "P6V/8VmK+8BLjc/s3r3prpbnRSm3MqVbdk/wtoUWu9OPXbW0w7JuJt/+vbu+" +
       "dNtbD3fS79o1+LhznGjbo1d+YdbzwmT7Jiz/9df/6rv+wbN/vL0a/v8BQCex" +
       "R9M+AAA=");
}
