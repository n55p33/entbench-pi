package org.apache.batik.dom.svg;
public class SVGOMTextElement extends org.apache.batik.dom.svg.SVGOMTextPositioningElement implements org.w3c.dom.svg.SVGTextElement, org.apache.batik.dom.svg.SVGMotionAnimatableElement {
    protected static final java.lang.String X_DEFAULT_VALUE = "0";
    protected static final java.lang.String Y_DEFAULT_VALUE = "0";
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextPositioningElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform;
    protected java.awt.geom.AffineTransform motionTransform;
    protected SVGOMTextElement() { super(); }
    public SVGOMTextElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { transform =
                                                createLiveAnimatedTransformList(
                                                  null,
                                                  SVG_TRANSFORM_ATTRIBUTE,
                                                  "");
    }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
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
    public org.w3c.dom.svg.SVGRect getBBox() { return org.apache.batik.dom.svg.SVGLocatableSupport.
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
    protected java.lang.String getDefaultXValue() {
        return X_DEFAULT_VALUE;
    }
    protected java.lang.String getDefaultYValue() {
        return Y_DEFAULT_VALUE;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
      ("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" +
       "gX8ZpBd2k/fCyQP/I/U487T/jLej/+iM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("un+SZ69FpXcYjhEV99lU1LIoY6OiURQYyzhSw6LhZ47p5t+LSnduXEM5Utov" +
       "38wL16LgZw9FcP+Bzqo7Eag3I4KodI8XGBspUm8oh18+o+5X8uyXotLjR3K4" +
       "Wgh5/VeOAP+LWwD8UF6Y30+xd4Dtm53zD94Q6785o+7f5tnXotL9mhpRrixZ" +
       "zE5d0SN8X78FfI/mhXBevcOX3H58v3VG3X/Os29GpbcDfIwqBWoYCYaaeG5w" +
       "0r09cYoXPE5SiOLf36oocvN+cSeKF2+/KH7vjLo/yLPfBUCBKHApiPRrZZFT" +
       "fPsI7X+5BbQP54VPgPTSDu1Ltx/t/zqj7o/z7H8AjwDQdjpuejDNj50yzZP8" +
       "wuEh6v95C6iLd+r5FYDP7FB/5rajPnfujLoi3PjTqHQ3QI1x9AHot58CmpaA" +
       "O0uPYP/ZrcJ+GqRXdrBfuf2wL55R92CeXdj3YlM5UFUHgM/L7jrEd+4tt4rv" +
       "OZC+sMP3hduD79wRwbcLIO84neBgHt95mo9KZdXLQ5uigyfz7NGo9AiQxOFb" +
       "fM49su/jInnsFkRyOS/MvdmXdiL50u2f8mfPqIPy7PL+lF9zqeF9p8jp1NsZ" +
       "R7J45lbV4xmQXt/J4vWblcUNA7dzzTPq2nlWiUqXgCy66kqKrWhe3O7KiY8W" +
       "8nPV24HxF3cYf/H2Y8TOqMtvO5370FUYF6dh/KHbsWZ9dYfxq7cf4+iMunGe" +
       "DcCa5agJ4yrqgTpfOq7OhxUF3OEtwM0ddqkN0q/u4P7q7Yf7whl1V/JsDuLs" +
       "fRO+6tbY4U0w4wjr4hawFtfyfhCkb+ywfuNmsd7YXRln1Jl5pkSlhwBW+uqb" +
       "WDn5x45Q3vC+2xkoi7u+HZC+tUP5rduD8vzRhT/0QCnff81xgAQ87F5xjyq/" +
       "XH1wElAYaSGD+Az5bPPMA6oeewrw0qMoPys8MO+jvdY5/6Zu84L+Tn6jkd82" +
       "f/yaT8D2P1uSf/7Vi/c+9ir/reIzhcNPi+6jSveuYss6fsH12PPdXqCujEJu" +
       "9+1fd/UKSJ8Amn29I5OodAfIc4bPvbhP/Tej0ttOowaUID9O+dLOIRynjEp3" +
       "Ff+P0/2dqHThiA7EhPsPx0l+HPQOSPLHz3gHE1u78fcuB58tGY52cNCzH6M8" +
       "flwvi7DyoRtN2GGT419E5Oc7xed8B2cx8f4HfVfk118dMB/7XuNn9r/IkC0p" +
       "y/Je7qVK9+x/HFJ0mp/nPH3d3g76upt49vsP/MJ9zxycPT2wz/CRjRzj7V2n" +
       "f/vQs72o+Foh++eP/dMP/MNXf7u4Jvj/AdFUAtZnOQAA");
}
