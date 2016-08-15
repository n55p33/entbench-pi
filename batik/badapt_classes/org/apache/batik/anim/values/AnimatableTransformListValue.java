package org.apache.batik.anim.values;
public class AnimatableTransformListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWX =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWY =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SCALE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_ROTATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_TRANSLATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    static { IDENTITY_SKEWX.setSkewX(0.0F);
             IDENTITY_SKEWY.setSkewY(0.0F);
             IDENTITY_SCALE.setScale(0.0F, 0.0F);
             IDENTITY_ROTATE.setRotate(0.0F, 0.0F, 0.0F);
             IDENTITY_TRANSLATE.setTranslate(0.0F, 0.0F); }
    protected java.util.Vector transforms;
    protected AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        org.apache.batik.dom.svg.AbstractSVGTransform t) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            );
        this.
          transforms.
          add(
            t);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.util.List transforms) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            transforms);
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableTransformListValue toTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            to;
        org.apache.batik.anim.values.AnimatableTransformListValue accTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            accumulation;
        int accSize =
          accumulation ==
          null
          ? 0
          : accTransformList.
              transforms.
          size(
            );
        int newSize =
          transforms.
          size(
            ) +
          accSize *
          multiplier;
        org.apache.batik.anim.values.AnimatableTransformListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableTransformListValue)
                result;
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accTransformList.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        for (int i =
               0;
             i <
               transforms.
               size(
                 ) -
               1;
             i++,
               index++) {
            res.
              transforms.
              setElementAt(
                transforms.
                  elementAt(
                    i),
                index);
        }
        if (to !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                toTransformList.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              null;
            int type;
            if (transforms.
                  isEmpty(
                    )) {
                type =
                  tt.
                    getType(
                      );
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        ft =
                          IDENTITY_SKEWX;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        ft =
                          IDENTITY_SKEWY;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        ft =
                          IDENTITY_SCALE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        ft =
                          IDENTITY_ROTATE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        ft =
                          IDENTITY_TRANSLATE;
                        break;
                }
            }
            else {
                ft =
                  (org.apache.batik.dom.svg.AbstractSVGTransform)
                    transforms.
                    lastElement(
                      );
                type =
                  ft.
                    getType(
                      );
            }
            if (type ==
                  tt.
                  getType(
                    )) {
                org.apache.batik.dom.svg.AbstractSVGTransform t;
                if (res.
                      transforms.
                      isEmpty(
                        )) {
                    t =
                      new org.apache.batik.dom.svg.SVGOMTransform(
                        );
                    res.
                      transforms.
                      add(
                        t);
                }
                else {
                    t =
                      (org.apache.batik.dom.svg.AbstractSVGTransform)
                        res.
                          transforms.
                        elementAt(
                          index);
                    if (t ==
                          null) {
                        t =
                          new org.apache.batik.dom.svg.SVGOMTransform(
                            );
                        res.
                          transforms.
                          setElementAt(
                            t,
                            index);
                    }
                }
                float x;
                float y;
                float r =
                  0;
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        r =
                          ft.
                            getAngle(
                              );
                        r +=
                          interpolation *
                            (tt.
                               getAngle(
                                 ) -
                               r);
                        if (type ==
                              org.w3c.dom.svg.SVGTransform.
                                SVG_TRANSFORM_SKEWX) {
                            t.
                              setSkewX(
                                r);
                        }
                        else
                            if (type ==
                                  org.w3c.dom.svg.SVGTransform.
                                    SVG_TRANSFORM_SKEWY) {
                                t.
                                  setSkewY(
                                    r);
                            }
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getA(
                                  );
                            y =
                              fm.
                                getD(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getA(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getD(
                                     ) -
                                   y);
                            t.
                              setScale(
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        {
                            x =
                              ft.
                                getX(
                                  );
                            y =
                              ft.
                                getY(
                                  );
                            x +=
                              interpolation *
                                (tt.
                                   getX(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tt.
                                   getY(
                                     ) -
                                   y);
                            r =
                              ft.
                                getAngle(
                                  );
                            r +=
                              interpolation *
                                (tt.
                                   getAngle(
                                     ) -
                                   r);
                            t.
                              setRotate(
                                r,
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getE(
                                  );
                            y =
                              fm.
                                getF(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getE(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getF(
                                     ) -
                                   y);
                            t.
                              setTranslate(
                                x,
                                y);
                            break;
                        }
                }
            }
        }
        else {
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                res.
                  transforms.
                elementAt(
                  index);
            if (t ==
                  null) {
                t =
                  new org.apache.batik.dom.svg.SVGOMTransform(
                    );
                res.
                  transforms.
                  setElementAt(
                    t,
                    index);
            }
            t.
              assign(
                ft);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        int type =
          ft1.
          getType(
            );
        float x;
        float y;
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            x =
              ft1.
                getMatrix(
                  ).
                getA(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getD(
                  );
        }
        else {
            x =
              ft1.
                getMatrix(
                  ).
                getE(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getF(
                  );
        }
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            if (type ==
                  org.w3c.dom.svg.SVGTransform.
                    SVG_TRANSFORM_SCALE) {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getA(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getD(
                         ) -
                       y);
            }
            else {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getE(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getF(
                         ) -
                       y);
            }
        }
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            t.
              setScale(
                x,
                y);
        }
        else {
            t.
              setTranslate(
                x,
                y);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to3,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        float interpolation3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft3 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value3.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        float x;
        float y;
        float r;
        r =
          ft1.
            getAngle(
              );
        x =
          ft2.
            getX(
              );
        y =
          ft3.
            getY(
              );
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt3 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to3.
                  transforms.
                lastElement(
                  );
            r +=
              interpolation1 *
                (tt1.
                   getAngle(
                     ) -
                   r);
            x +=
              interpolation2 *
                (tt2.
                   getX(
                     ) -
                   x);
            y +=
              interpolation3 *
                (tt3.
                   getY(
                     ) -
                   y);
        }
        t.
          setRotate(
            r,
            x,
            y);
        res.
          hasChanged =
          true;
        return res;
    }
    public java.util.Iterator getTransforms() {
        return transforms.
          iterator(
            );
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo1(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo2(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                return java.lang.Math.
                  abs(
                    t1.
                      getX(
                        ) -
                      t2.
                      getX(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo3(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        if (type1 ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_ROTATE) {
            return java.lang.Math.
              abs(
                t1.
                  getY(
                    ) -
                  t2.
                  getY(
                    ));
        }
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableTransformListValue(
          target,
          new java.util.Vector(
            5));
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        java.util.Iterator i =
          transforms.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                i.
                next(
                  );
            if (t ==
                  null) {
                sb.
                  append(
                    "null");
            }
            else {
                org.w3c.dom.svg.SVGMatrix m =
                  t.
                  getMatrix(
                    );
                switch (t.
                          getType(
                            )) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        sb.
                          append(
                            "translate(");
                        sb.
                          append(
                            m.
                              getE(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getF(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        sb.
                          append(
                            "scale(");
                        sb.
                          append(
                            m.
                              getA(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getD(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        sb.
                          append(
                            "skewX(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        sb.
                          append(
                            "skewY(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        sb.
                          append(
                            "rotate(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getX(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getY(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                }
            }
            if (i.
                  hasNext(
                    )) {
                sb.
                  append(
                    ' ');
            }
        }
        return sb.
          toString(
            );
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
       "NtYXXt9O4v3FpunhLbSF08gLfv517KCl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("tzoULT4XS6duLh3bQj52aFfKdwUfO+tyWbEj+NmPvPiSwf0icnAy+ffi0qXY" +
       "D37YMdemc4zU3YDSs2fvfjLF3bqjQ7gvf+S/PiK9f/6h13ET54lTfJ4m+XeZ" +
       "l79CvFP/a3ul2w6P5G669Xey0XMnD+Iuh2achJ504jjusUPJ/uCBNN19ybqn" +
       "N+ePxu7WJwDP78b+1HnsHUWFOw42y9/9Gm9QFSeSeZsvFy3/1jFt+Vy+Qe/4" +
       "Wnxm8W22t7vS8RvnHA7/izz59bh0d3GpEkhSi491WKjnP3ndJ/+/dihPKM98" +
       "DxDN3q7t7vs1ynPvyKpuKdRLu1PpgsJZyVcOk+LnVwtCXz9HIP8uT/7VzQI5" +
       "Zq+/82YI5AP7AvnAmyiQe4pa95wrkFuJ5rR8/vM58vlWnvyHc+Xze29APvnB" +
       "WOkpIJeX9+Xz8ptjgMch/M9zyv5Xnnw7Lt1rmbF01hFecZ/lwfOYPDD0B46O" +
       "8KjYLG6s5SXfPRLWf38Dwnowz3wE9P/FfT6++KYL68LeOWW355l/Epfu1DVv" +
       "eHAf+5QXunPq+46peUeI//QNIC5mP+CkL3xpH/GX3hzEF44qfLmAdv85sB/M" +
       "k3vi0mXD3s0xUnHD+CuHEC/c+0YhPgqY+fo+xK9/nyA+dg7EJ/LkYWDlRxCR" +
       "Uxh/4M3A+N19jN/9PmF85hyM5Ty5dgJj5RTGp98EjHtv2bXdfX8fMNbOwZjH" +
       "mxfgExjRUxiRN4CxCJfeBbA9s4/xmTcH43EI2Dll7Tx5b1y6B3jriRn6p+Kl" +
       "At/73gC+B/LMxwCu/ctJezddTnrj+Jhzyrg8IcHwxf7uUoVgFv3+/BE86nXd" +
       "5otLj553Pz+/afzwTX8X2v3FRf/ll67c9baXRv+6uKJ++DeUS3TprlniOMcv" +
       "ux17vxiE5swuhHBpd/UtKJDJgJPzguC4dHH3kmO4MNo1UuPSQ7dsFJduz7+O" +
       "1/1AXLp6ui4ImYvv4/VuAD9+VA90u3s5XmUKYmlQJX/Vg53d7W5XP3xca4q5" +
       "7YFXG41ji7J3nFhKFf/lOlj2JMP926mff6nP/th36r+4u16vO1qW5VTuokt3" +
       "7m76F0TzpdNTZ1I7oHWRfOZ7933h0tMHy7z7dgwfafAx3p649UX2rhvExdXz" +
       "7B++7Yvv/dsv/W5x1eb/AWosZGhkNwAA");
}
