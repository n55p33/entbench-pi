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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iasP/IsgPb+dvOdPHvjv1OPM0/4z3o7+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ozPq/kmWvR4W3qXbepjfZ1NQ06T0tYKGoa8volAJ8oafOaabPxEW7lw7urxT" +
       "2i/fzAvXvODnjkRw36HOKlsRKDcjgrBwt+vrazFUbiiHXzmj7lez7JfDwmM7" +
       "OVwthKz+KzvA/+IWAD+YFWb3U6wtYOtm5/zDN8T6b86o+7dZ9rWwcJ+qhJQj" +
       "iSazVVd0h+/rt4DvkawQzqq3+OLbj++3z6j7z1n2zbDwToCPUURfCcKJrsSu" +
       "4590b4+f4gWPk+Si+Pe3KorMvF/ciuLF2y+K3z+j7g+z7PcAUCAKXPRD7VpZ" +
       "ZBTf3qH9L7eA9qGs8HGQXt6iffn2o/2fZ9T9aZb9D+ARANpWy0kOp/nRU6Z5" +
       "lF04PEL9x7eAOn+nnl0B+MwW9WduO+pz586oy8ONPw8L5wFqjKMPQb/zFNC0" +
       "CNxZsoP9F7cK+ymQXt3CfvX2w754Rt0DWXbhwIuNJV9RbAA+K7vrCN+5t90q" +
       "vmdB+sIW3xduD75zO4Jv50DedTrB4Ty++zQflUiKm4U2eQdPZNkjYeFhIImj" +
       "t/ics7Pv4yJ59BZEcjkrzLzZl7Yi+dLtn/JnzqiDsuzywZRfc6nhA6fI6dTb" +
       "GTtZPH2r6vE0SG9sZfHGzcrihoHbufoZdc0sK4WFS0AWbWUpRmY4y293ZcS7" +
       "hfxc+XZg/KUtxl+6/RixM+qy207nPnIVxvlpGH/odqxZX91i/Ortxzg4o26Y" +
       "ZT2wZtlKzDiycqjOl46r81FFDrd/C3Azh11ogvRrW7i/dvvhPn9G3ZUsm4E4" +
       "+8CEr7o1dnQTTN9hnd8C1vxa3g+C9I0t1m/cLNYbuyv9jDojy+Sw8CDASl99" +
       "Eysj/8QO5Q3vu52BMr/r2wLpW1uU37o9KPd2F/7QQ6X84DXHASLwsPv5Pars" +
       "cvXhSUBupLkMojPks8kyF6h65MrASw/C7Kzw0Lx3e61z3k3d5gX9nfxGI7tt" +
       "/tg1n4AdfLYk/cJrF+959DX+W/lnCkefFt1LFe5ZRqZ5/ILrsefzrq8s9Vxu" +
       "9x5cd3VzSC8Bzb7ekUlYuAPkGcPnXjyg/tGw8I7TqAElyI9Tvrx1CMcpw8Jd" +
       "+f/jdH8nLFzY0YGY8ODhOMnfA70DkuzxM+7hxFZu/L3L4WdLuq0eHvQcxCiP" +
       "HdfLPKx88EYTdtTk+BcR2flO/jnf4VlMdPBB3xXpjdd6zCe+V/vZgy8yJFNM" +
       "06yXe6jC3Qcfh+SdZuc5T123t8O+zhPPfP/+X7z36cOzp/sPGN7ZyDHe3nP6" +
       "tw8dyw3zrxXSf/7oP/3QP3ztd/Jrgv8Pm0zSomc5AAA=");
}
