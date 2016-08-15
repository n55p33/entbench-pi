package org.apache.batik.dom.svg;
public abstract class AbstractSVGPointList extends org.apache.batik.dom.svg.AbstractSVGList implements org.w3c.dom.svg.SVGPointList {
    public static final java.lang.String SVG_POINT_LIST_SEPARATOR = " ";
    protected java.lang.String getItemSeparator() { return SVG_POINT_LIST_SEPARATOR;
    }
    protected abstract org.w3c.dom.svg.SVGException createSVGException(short type,
                                                                       java.lang.String key,
                                                                       java.lang.Object[] args);
    public org.w3c.dom.svg.SVGPoint initialize(org.w3c.dom.svg.SVGPoint newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPoint)
                                                initializeImpl(
                                                  newItem);
    }
    public org.w3c.dom.svg.SVGPoint getItem(int index)
          throws org.w3c.dom.DOMException { return (org.w3c.dom.svg.SVGPoint)
                                                     getItemImpl(
                                                       index);
    }
    public org.w3c.dom.svg.SVGPoint insertItemBefore(org.w3c.dom.svg.SVGPoint newItem,
                                                     int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPoint)
                                                insertItemBeforeImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPoint replaceItem(org.w3c.dom.svg.SVGPoint newItem,
                                                int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPoint)
                                                replaceItemImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPoint removeItem(int index)
          throws org.w3c.dom.DOMException {
        return (org.w3c.dom.svg.SVGPoint)
                 removeItemImpl(
                   index);
    }
    public org.w3c.dom.svg.SVGPoint appendItem(org.w3c.dom.svg.SVGPoint newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPoint)
                                                appendItemImpl(
                                                  newItem);
    }
    protected org.apache.batik.dom.svg.SVGItem createSVGItem(java.lang.Object newItem) {
        org.w3c.dom.svg.SVGPoint point =
          (org.w3c.dom.svg.SVGPoint)
            newItem;
        return new org.apache.batik.dom.svg.AbstractSVGPointList.SVGPointItem(
          point.
            getX(
              ),
          point.
            getY(
              ));
    }
    protected void doParse(java.lang.String value,
                           org.apache.batik.dom.svg.ListHandler handler)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.PointsParser pointsParser =
          new org.apache.batik.parser.PointsParser(
          );
        org.apache.batik.dom.svg.AbstractSVGPointList.PointsListBuilder builder =
          new org.apache.batik.dom.svg.AbstractSVGPointList.PointsListBuilder(
          handler);
        pointsParser.
          setPointsHandler(
            builder);
        pointsParser.
          parse(
            value);
    }
    protected void checkItemType(java.lang.Object newItem)
          throws org.w3c.dom.svg.SVGException {
        if (!(newItem instanceof org.w3c.dom.svg.SVGPoint)) {
            createSVGException(
              org.w3c.dom.svg.SVGException.
                SVG_WRONG_TYPE_ERR,
              "expected.point",
              null);
        }
    }
    protected class SVGPointItem extends org.apache.batik.dom.svg.AbstractSVGItem implements org.w3c.dom.svg.SVGPoint {
        protected float x;
        protected float y;
        public SVGPointItem(float x, float y) {
            super(
              );
            this.
              x =
              x;
            this.
              y =
              y;
        }
        protected java.lang.String getStringValue() {
            return java.lang.Float.
              toString(
                x) +
            ',' +
            java.lang.Float.
              toString(
                y);
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix matrix) {
            return org.apache.batik.dom.svg.SVGOMPoint.
              matrixTransform(
                this,
                matrix);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8zsRnX3/ZJ78yC59yaQEALkxeWRmH5er72vhhbW3vWu" +
           "vfau1/a+XODGz12vn2t7d72maYHSEoEEUZtQSiGtKlAoChBV0FRCoLSoPARC" +
           "okWlReLRqlJpKRL8UVo1benY+73udx8hIu1KnrVnzpw5vzNnfjOe8RM/hE5G" +
           "IQQHvrOZOn68ayTx7twp7cabwIh2GbbEK2Fk6KSjRJEE8s5r9zx55ifPPDw7" +
           "uwOdkqEXKp7nx0ps+V4kGJHvrAydhc4c5jYdw41i6Cw7V1YKsowtB2GtKL6f" +
           "hV5wpGoMnWP3TUCACQgwAclNQOqHUqDSjYa3dMmshuLF0QL6NegEC50KtMy8" +
           "GLr7QiWBEirunho+RwA0XJs9DwGovHISQncdYN9ivgjwozDyyO+++eyfXAWd" +
           "kaEzlidm5mjAiBg0IkM3uIarGmFU13VDl6GbPMPQRSO0FMdKc7tl6ObImnpK" +
           "vAyNAydlmcvACPM2Dz13g5ZhC5da7IcH8EzLcPT9p5Omo0wB1lsPsW4RUlk+" +
           "AHi9BQwLTUUz9qtcbVueHkN3Hq9xgPFcBwiAqte4RjzzD5q62lNABnTztu8c" +
           "xZsiYhxa3hSInvSXoJUYuv2ySjNfB4pmK1PjfAzddlyO3xYBqetyR2RVYuiW" +
           "42K5JtBLtx/rpSP988Pu697zFq/t7eQ264bmZPZfCyrdcaySYJhGaHiasa14" +
           "w33s+5RbP/vQDgQB4VuOCW9lnvrVH7/htXc8/aWtzEsvIdNT54YWn9c+rJ7+" +
           "+svIe2tXZWZcG/iRlXX+Bcjz8Of3Su5PAjDybj3QmBXu7hc+LXxh8taPGT/Y" +
           "ga6noVOa7yxdEEc3ab4bWI4RtgzPCJXY0GnoOsPTybychq4B96zlGdvcnmlG" +
           "RkxDVzt51ik/fwYuMoGKzEXXgHvLM/39+0CJZ/l9EkAQdBpcEAuuh6HtL/+P" +
           "oQeQme8aiKIpnuX5CB/6Gf4IMbxYBb6dISqIehuJ/GUIQhDxwymigDiYGXsF" +
           "uu8i0WqK1FUQ6IoWi8MW74OYzWhhN4u04P+hjSTDeXZ94gTogpcdJwAHjJ22" +
           "7+hGeF57ZEk0f/yJ81/ZORgQex6KoV8Eze5um93Nm90Fze6CZncv1ey5/Qc6" +
           "NlzoxIm86Rdltmx7HvSbDRgASN5wr/gm5oGH7rkKhFywvho4PRNFLk/R5CFn" +
           "0DkzaiBwoaffv37b8NcLO9DOhVyb2Q+yrs+q8xlDHjDhueNj7FJ6z7zz+z/5" +
           "5Pse9A9H2wXkvUcCF9fMBvE9xz0d+pqhA1o8VH/fXcqnz3/2wXM70NWAGQAb" +
           "xgqIXkA0dxxv44LBfP8+MWZYTgLAph+6ipMV7bPZ9fEs9NeHOXkInM7vbwI+" +
           "PpNF90vB9Qd74Z7/Z6UvDLL0RduQyTrtGIqceH9JDD70t1/7Zyx39z5Hnzky" +
           "64lGfP8RXsiUnckZ4KbDGJBCwwBy334//zuP/vCdv5IHAJB4xaUaPJelJOAD" +
           "0IXAzb/5pcXfffc7H/7GzmHQxGBiXKqOpSUHIK+F9gb25UCC1l51aA/gFQeM" +
           "uyxqzg0819ct01JUx8ii9L/OvBL99L++5+w2DhyQsx9Gr312BYf5LyGgt37l" +
           "zf9+R67mhJbNa4c+OxTbkuULDzXXw1DZZHYkb/url//eF5UPAdoFVBdZqZGz" +
           "107ugx1Q6d4rrG1CywW9sdqbD5AHb/6u/cHvf3zL9ccnj2PCxkOPvOunu+95" +
           "ZOfIDPuKiya5o3W2s2weRjdue+Sn4HcCXP+TXVlPZBlblr2Z3KP6uw64PggS" +
           "AOfuK5mVN0H90ycf/MxHH3znFsbNF04wTbB++vjf/PdXd9//vS9fgtNA5PpK" +
           "3pNYbiiSG3pfnu5mluVuhfKy+7Pkzugob1zo4SNLt/Paw9/40Y3DH33ux3mj" +
           "F679jg4TTgm2LjqdJXdliF98nCTbSjQDcvjT3TeedZ5+BmiUgUYNzARRLwSs" +
           "nVwwqPakT17zrT///K0PfP0qaIeCrgcodUrJ+Qm6DhCDEc0A4SfB69+wHRfr" +
           "bKSczaFCF4Hfjqfb8qeTV44wKlu6HbLbbf/Zc9S3/8N/XOSEnJQvEXTH6svI" +
           "Ex+8nfzlH+T1D9kxq31HcvFMBpa5h3WLH3P/beeeU3+5A10jQ2e1vTX0UHGW" +
           "GefIYN0Y7S+swTr7gvIL14DbBc/9B+z/suNRf6TZ47x8GG3gPpPO7q8/RsU3" +
           "Z16+HVyP7rHUo8ep+ASU39B5lbvz9FyWvHqf+a4LQj8GVhp6rhuP9/ge25J4" +
           "lr4uS5htX77+sv3euNiqD+xZ9YHLWNW/jFXZLXdgzuZS5gjPak5ePTkBIJ4s" +
           "7lZ2C9nz+NINXpXdvgbMAlH+wpINbstTnH0LXjx3tHP7LDMELzAgDs/NnUqu" +
           "5hbwypYPoazHd7er/mO24j+zrWCInD5UxvrgBeLd//jwV9/7iu+COGagk6ss" +
           "xkD4Hmmxu8zeqX7riUdf/oJHvvfufFIDHhy+45nb35Bp1a6EOEvemCVv2od6" +
           "ewZVzBeLrBLFXD4PGfoB2sIRPOUYzGb+z4E2Pv2pNh7R9f0fi8qNcX04TEZw" +
           "ZTNqNnmWR1C43uzMqzUWE6nZqEHVpwxBVac22mgRy1ZSHOtmFBIrvRJXxkhH" +
           "dGJ/46OkztkWQcc9K41IWx7NCGE90WeDZqXgyUpBkCNhMiiX/cSXJ0IS0mW/" +
           "JicVvYYsi4gmcZuuK7vVol6tlmqldOWFtYqG0G5rNJIDurRguX6r0VpQ7nw8" +
           "YgN7NJdGge0O4xnr+gi1EWqMEXdrk1VD7oisw8od1IkjVxIof7TglCWbUvWC" +
           "VXAVqYOhDqf0/VrRpubjCtNR/dHMkH3KislBdyjTI7QstToEE9lcgVkwnMwF" +
           "0opROlE8ZZpyU6/baWPAhIiAqP6mrzk2RjjpZiNUNkxUHQfNDa6gLjdsGkUR" +
           "Q8UeZw+6QiKwXWXCRQ7ZR7W24Yj6bGR1ZqoSisU1jdoAZJPqm5VwsU5XFWMR" +
           "lQhQUdI5uVtFFj6jLGsxNZlRYimqFhbS0OJtS6cHE5GrCfW0MCMSaoo1fJea" +
           "oGx7FPTZuFO2RlJDCjAidUXST2RKpG3dlfvTlHGITtFtK0uuMPVlVY09wo08" +
           "eVQcOpYsGywxM5qNtFiMEWciLAzfGk7CkWWEtF8XG4Lq1wF6P1goKDdT5pFY" +
           "Ev0q5eooI9lDwSl0K8HIXgUFURzNeig24dpM0KS6q4XCUsZ6XmxNXFlRVMXk" +
           "LazTjlYFlRoqdltlML9o+ZHKUSWOJbi6NuaWdQGWK9yggpKFFsmliJAErSSC" +
           "62up3psHxEiBjfEimNhFkkTr/nggjmKmtmbChYnWe7bfFtK+3BIW40WLjsU2" +
           "0yv3jZY94mvdFmoVavXuZNKYihtO4klJG7hrEe3WlrAke6VV6MBoTaKWITGw" +
           "6zpdEkaDcS1ZM5I3gYNpVQlEsdkjWnxpGk1nitEp8QOKnLYtco7O+14bq9b8" +
           "gNIF3aBSSdJiIip3Sz1ZUIZzbDhezYs1xayItCPO0W49JiQNWWO0IRtY0akq" +
           "g7rguBPHt8zputTe1ArjdmpvBL4w3dQDZTNwogXuNmGi3VU7BkeIQ9dd+oJd" +
           "ZArDadga9NARwSOYHbTWWNwsKNYEE0h+VBJR2+0MpdLYR1pwvVPHrWaH3hiU" +
           "UVj2ytVWwoYloxpME0Ik+zCzZnu8RSCwW6JifIjX+lpPZFtuJ/BNVRKwOK52" +
           "+prqE8Vaad3F5rV5SDpMAV2vVWJZ8/tOle4aigfT5Ym7RnVNGsd2d25VmLDN" +
           "S6430U1CSaX1tJaaUyRkKLJXNVFi3VkTOl8jByRVpNxwkVILYTlobIbjbozC" +
           "zMpyNXLNk4JvCVK1taFVKrLIqjp1h42otfbRCt1NZ3A8J2Wa5shx24fLFlNs" +
           "m3pEtPp1fwPrmOq4mDqo1ZqqpRWGVc4nu4E5mASKx0ozhld9pBMU/ZAo6tp4" +
           "lfh2IlAiCUceIwzCTWGRElhntOK4Xhlhlh2KWYby3FkIw0mpmejBnKKHprOY" +
           "WUVn2IPnTISnXIzP14pjt1h+hrQHdoBU7PWyDQepXENCfEqOlBGBJhuq1S/K" +
           "LaQdMKUeNsXgmCFYNR4DtoWNXihIetJtCiEQdPsjphb0K5jW49NEMLRmVB6k" +
           "BYzDW41VNBF7BDf1yQZGzb3xhpsjab+8FJK40x818MpCtimpWmoRWuIF3ZUO" +
           "6/iwpK5rSHuKxoPJgOhNYT3UfWmDITPU99tzptd2yi0N7mBWDLdFr6qxPItg" +
           "s3q/jA1QZcHzaJ0pjrqeI7bWblAqLIIEGytzUfT6Y2mlIcuUcCsRppWqlDUH" +
           "0eSm9agPhFvr2ZrfUGgC1+BVBZ2gBhkG1XTRGzOqazED156LuKtbCC2Tyqqr" +
           "ISNi2JmRC5tcKePZpI7UBrgfDsIhzYXt2igdotWSXass8IG5aDTmy27Lwvsj" +
           "vIp2R7Zomhi/wHoW7tItLtDnVLoZCHAb1jtj11UK08bCHocLT3BMc4CW66JP" +
           "yS2dbSn9Kt6flIiozY04HS/bCcm7Nub0hahfqulLuLTCNupKGc0RT5mxA4xe" +
           "k6zPsLhiFk3JqIUmzgS6Vepx1aKDzazRim4SOL9I1Km57iP18Rye92FyPutZ" +
           "RNwvFidDfxj6Ymsw6XSZmum3x1yXJKsRotbaGmIalD3BO8iAdzvlUpUc89Mw" +
           "5kWiKIX9VKvQZdKCeaXlNnvSNBIM1KXQBaVVpCoSS71KpYhrFbO/mCtpr6E3" +
           "Koi3WSK1cgeTcLSI2Iu61u+Hvu3GdLsge9JiHFdLS5y20QkyNsc1Ux1SrFxH" +
           "R7YTDBzOkHR25FKaW2t1R1G8TMej8jwhjWqybI84gpnU2WW9WUJsPOksNxga" +
           "zPvzscUTKwVrTRTMTpWe0jPMcLlg09VmUexIqtnDYHkkp+oS8yWBmdlkdeZr" +
           "Jatt28h6qC5Qu9Zn9WlijsxySVmN622mrRAC4XWW7JiYgYl8Y09X3dXIL6gI" +
           "vlYiKa6gukDTcVBPpnMQKDzVkzi5bi30AYtKgcOzAmCKGZwS3hCjRFEepyOi" +
           "qQZpN02w0nrdopHJ2qhx8ErZ+Ao/NhR/M6OToDwmdc9pKbDZ5sM+7rEeYsmF" +
           "rtnT+yu+E9RNfo4zq9p8WlvUyqmOpHhHo6qcRhv8vLJemGa7tCggNN9ja6oj" +
           "kxVaHuu1JuHomLfiS21cqZBwqakTXLhgh9yqqI2WUkBOEhQziabW3aQusWa4" +
           "Fe55jtZk0WQC1g3SymyHLV02U6xA2HSywYhyvJZG+EzuzQxjOhYKPdiOp1Oe" +
           "HLNRadNIqmO8Ta4GWLvV6qi9fjNSqslId6eMRety06ftjlXkwkawpObNmTGs" +
           "bSah6QsGXpgbQ3E8M3xc5TzQ11VMaVh9sdqd1PuotByq1mDIzvi1jpOVutro" +
           "t2F+Zvd4farW0uo0QGMrQFaU16jPMdTtBTAxX65xbT4q4Kv5zJfL/rBASBOh" +
           "mGC+QA/shCqqZuqXV+E61sLaCkGX/Sq8sCWp0aM0TGKXrFmFm3Vq0edLbG0R" +
           "boplvCZ1N5UVJinkCrzRNTYdZMOYihSWEzkoV/nqnC+LHTyKKpg7AAtPkRrK" +
           "TmfUZcecMqe9lRFLGsOvpiOTxlajGcaiDq2bXIIupmwDNfBuJPX4fjqInYar" +
           "Wm2c8Nqa6iy8iEsqE6k5rJneoNqlZKNJTgVOJwIYKzhyjwaL06BYCKV1tVHg" +
           "2MiZT0xl3eyvnHRaTDncZFrCZNrwozQtjvuzIlYo0GkcFD2iUCJ4Z0KWZqUl" +
           "R2J0Oq12NgSe1E1iqkb1ugST6UT1Vi2sDctUw6aRoVxWdQnrAB6U5sS4PgFz" +
           "TjilOSqM6kHLoyadZVImG5VCeRByiTFR9aSnWhWFoApGT5IqI1ytlwZrUo1S" +
           "S6Pi2bqNeUxitFR93WpvzGl3ANtOsTRj6ao2axfjZZvZDHrksE2NyhLdcF2Y" +
           "oRG23hAFIe31x0sT5/uqNHDTKk2TQcItQRZCYZbTIj0M8/FSOa5W/GlULNen" +
           "roxijgXHHqCD+VAZSfN5pdp2q62CYzZLw8YILzjDmqQo3koT12UhmSldgY2D" +
           "nqbOywsdM0rdDmeL9GTZbyJNXRy3BNe0Et+fmIK4mkZo2qwyQSGEi4UYc+Tm" +
           "xlmXyzTSthjTHop1TTRZEJhtAq6wMNFEKJ6QNroTorHJal6DNVVFUFcNoVEU" +
           "kMTkBvjKTiQEhE0nwMvLEYJMKpOqSaV6H7yydhuLziAaNzaUrM/K45KvO6Vg" +
           "vtiIscmvhgxucDU9aBWXzbVb8iWzi+trrWlNmu1V2YXLiRvSY5TVkPEkWnEI" +
           "5vCbxmwz7Qa9esJZeKrbnlsShVlTLmgbqTKrwzW6AsZjkCByq1HyV5ZpVj1+" +
           "bksa2Ux5KYGH4TqJl2qCVMNWmSY8VbRlQigAAJyFGnYj9NsdszgYLKgOeAcR" +
           "FyTVHIpcGec7cavEjBKkR+IgHsfBSN0gcqcPwzBuw7XJOI29GkptHKYymFgL" +
           "t47FIx3EiWkLhbU88BrVRgvnSpVKoI8sqkctp0ytRReLLXy4jsFrmII33Vlv" +
           "qC9UWNViZBo2QhMBSszQgt12v17PXl/95/ZafVO+g3BwiAjeprOC88/hzTm5" +
           "4lbJwdZLvu124/GjqKPb1ocbcif29y9uy45n1ph2cCqzfwCT7Sm+/HLHifkO" +
           "6off/shjeu8j6M7eTmclhk7tnfIeNnQKqLnv8jt/XH6Uerj99sW3/8vt0i/P" +
           "HngO5zF3HjPyuMo/5p74cutV2m/vQFcdbMZddMh7YaX7L9yCuz404mXoSRds" +
           "xL38wO8vydz8anA9vuf3xy99JvKs+11X2EV+6Apl78qS34ih01Mj3u5B5duR" +
           "eZQdBtg7nm1r5qjaPOOtBwhvgfZgPrmH8MnnivA1z4rwkSuUvS9L3htDVwOE" +
           "43xH8BDXw88Hrqf2cD31/OP6wyuU/VGW/P4W1+QYrg/+HLjyU7q7wfW5PVyf" +
           "e35wnTgU2B58PHEFcJ/IkscBuAh02iU3EFe+pR8C/ujzAfgLe4C/8H8E+DNX" +
           "APzZLPnTLeC8N588BPfUzwHutiwz45ev7YH72vMKbn8meMklZgJOAXyS5LW/" +
           "eAXkX8mSv4ihM24uL4WKF2VHy1l2euiEzz8XJyQxdMPRjwH2zfyF5/Q9AZh9" +
           "brvoy6Xt1zbaJx47c+2LHxt8Mz9EP/gi5joWutZcOs7RI5gj96eC0ACruFxy" +
           "eyAT5H/f2JtKL2VZDF0F0hzAX2+lvxlDL7qUNJAE6VHJb8XQ2eOSMXQy/z8q" +
           "9+0Yuv5QDszE25ujIt8D2oFIdvv3wb47X/OzuDPzf3LiyKy+F6N5r978bL16" +
           "UOXoGX22Esi/PNuftZfbb8/Oa598jOm+5cflj2y/EdAcJU0zLdey0DXbzxUO" +
           "Zv67L6ttX9ep9r3PnH7yulfuL1FObw0+HC9HbLvz0gfyTTeI8yP09M9e/KnX" +
           "Pf7Yd/Jjlv8F7BmC7RIoAAA=");
    }
    protected class PointsListBuilder implements org.apache.batik.parser.PointsHandler {
        protected org.apache.batik.dom.svg.ListHandler
          listHandler;
        public PointsListBuilder(org.apache.batik.dom.svg.ListHandler listHandler) {
            super(
              );
            this.
              listHandler =
              listHandler;
        }
        public void startPoints() throws org.apache.batik.parser.ParseException {
            listHandler.
              startList(
                );
        }
        public void point(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPointList.SVGPointItem(
                  x,
                  y));
        }
        public void endPoints() throws org.apache.batik.parser.ParseException {
            listHandler.
              endList(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fjvoFdaaVuOViUGZYUtmaLa0lNstkdSX3bRDVwfjgdORe0xJnpYKg9gY2eN2" +
           "21+TQqCQ+toNqWYvshcIQxc4eZ3UjHLLTwqaxdFJf7EYTSo1LYlSZjymezjr" +
           "J7wXj0Yzpdwdw1PCtxe05AzbbSxtVwqt7pKUxA4WdysjjELZRc8pxDWFG5SK" +
           "TFUNCWY+5KVFTejwUUVV3F5tVmpZ82DhyUXOiunlOiiOvRa1smk4xpt11PRW" +
           "s7gQDwZJUlyz/rRUqRAuiidCI6GFuNuTAktfC3wvdfAhHmh10C73kf5c1zkm" +
           "mK0jKVg0Ucxkkqm0YWediuujcaWJWSohk36w4Nki2m/UQlSUZaHWwjVdlTei" +
           "18EnM4ltouuxNGZIfMotQ9x1fKyvBKRtmQV1OWNL3HTapMPRdMguKMexA5Ee" +
           "rKfylOCbyqpVGZENb+bTvjtSGgw+VcgqH2ibMRvIZG2I9+jCEK32Kbs9skRt" +
           "xCZ9fsjU/DgdTpqUVi6Vq9TCVBImrMP1MYMGzXa3Ue9V3HnElSeAeFxGB3GP" +
           "GNENrzLtxXKJb2CzklJnmzyBV8Q5LAmdTVlDTKNjOSg2L1v0utaY9VVis+zx" +
           "LCdEo2GdRVjMQWuBpC/9YkscyoG5YodeOVrMisGMDRs1jt64zpwqcKV1mVHN" +
           "VSj3CjA/q/T95RQWhepCEAYs69qDONSiPj2UBg5vS3N3YC7s3iIKlghWoMVC" +
           "F+n2LXLmFulgXm/AYj9M/EmfQRJpGIwabbpIFOvkqBjoTr2j03w5QhZ4v40a" +
           "TAM18Ipd00xkhA1mXL/vCLxFjXuiSPFJkenIMJ2s6XnSUmf+YDjlQj7qO06r" +
           "25yOWyyZpFZCE/2oXZjHnaHasSJGxwcN1FnOpoWu4jcDy8GajC0wHNIqxfPS" +
           "0PFmDQ3XGpMNMhCmU7YeFXuDOW1Qgq9tUM+KvYpb62ktshPhKVEA86YS04iE" +
           "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" +
           "+ZaKJAAA");
    }
    public AbstractSVGPointList() { super(
                                      ); }
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
      ("H4sIAAAAAAAAAL17eczs1nXffE+7LOk9yZasKNpsPauRx36cfcgqi0nORg63" +
       "IWc4M2zrZ24z3MnhPuOqXtDaRg24TiInDpDoj8JJm1S2g7RBDCQp1AatYyRw" +
       "kTTdUjRKiqJJ6xqwWzRp6zbuJefb3/eepEruB/AOyXvuueece87vHt57v5e/" +
       "WbkjCivVwHe2a8ePr+l5fM1y2tfibaBH10iqzclhpGu4I0fRFLy7rr77Fy//" +
       "6Xc+a1y5VLlTqrxd9jw/lmPT9yJej3wn1TWqcvnkbd/R3SiuXKEsOZWhJDYd" +
       "iDKj+Hmq8rZTTePKVepIBAiIAAERoFIECD2hAo3u173ExYsWshdHm8pfqxxQ" +
       "lTsDtRAvrrzrLJNADmX3kA1XagA43F08i0CpsnEeVp4+1n2v8w0Kf64KvfiT" +
       "H7zyS7dVLkuVy6YnFOKoQIgYdCJV7nN1V9HDCNU0XZMqD3q6rgl6aMqOuSvl" +
       "lioPRebak+Mk1I+NVLxMAj0s+zyx3H1qoVuYqLEfHqu3MnVHO3q6Y+XIa6Dr" +
       "Iye67jUcFO+BgveaQLBwJav6UZPbbdPT4spT51sc63h1DAhA07tcPTb8465u" +
       "92TwovLQfuwc2VtDQhya3hqQ3uEnoJe48thNmRa2DmTVltf69bjy6Hk6bl8F" +
       "qO4pDVE0iSsPnycrOYFReuzcKJ0an28yP/iZD3sj71Ips6arTiH/3aDRk+ca" +
       "8fpKD3VP1fcN73sv9RPyI7/+qUuVCiB++BzxnuZX/uq3P/C+J1/5zT3N919A" +
       "wyqWrsbX1S8oD/zO4/hzyG2FGHcHfmQWg39G89L9ucOa5/MARN4jxxyLymtH" +
       "la/w/3T50V/Qv3Gpci9RuVP1ncQFfvSg6ruB6ejhUPf0UI51jajco3saXtYT" +
       "lbvAPWV6+v4tu1pFekxUbnfKV3f65TMw0QqwKEx0F7g3vZV/dB/IsVHe50Gl" +
       "UrkCrsr3g+vZyv7valHElQ9Bhu/qkKzKnun5EBf6hf4RpHuxAmxrQArwehuK" +
       "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" +
       "vi69/6gofj+uvC3Ug+KI0wVD/W/fiqCX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("D1WWv0f+/I3X8udvFsV/jIsUxvXTi/T847dCT+NQT+Mt1/MrJcGfva5R/Z9F" +
       "8V+BsnIQ6J52gbL/7U0o+0jx8hlwBYfKBm9U2RdeS9kfKwgObrv5pHZwR/Hy" +
       "z+PK/ceTWqHlEZA/fdNjeKcJS0t8901YojjLUfkhcH340BIffmsscWpUR0cq" +
       "Xb2pSsV3ykj2NEcPS9M8eOsZ8tkbGAXF6eZwf8j5eMorWT1cFPeBWUDzy9qL" +
       "8qvbU9/Uju15cP+btWcNXJ84tOcnvkeedfXmBGUEHTxbFE8V7mXoql14zOFH" +
       "z8H3naj69BtRNQep5EVnQItDbI/ecNx8f0Ra/dJLl+9+50uzf7VPw4+OMd9D" +
       "Ve5eJY5z+szRqfs7g1BfmaUh7tmfQCrz0oP3HyY4FzkRSJNBWQh98L49dQ3I" +
       "exE1oATlacommDbPU4IEtvw9TdcBgHRCB3L2/c1pEgRwByTF7V8Mjhz2B17P" +
       "mdryY33v44+edq4yxh96rYE6bnL6lGXxTVX+u8DR93Sy/4eB6+qXXyKZD3+7" +
       "87P7U56qI+92BZe7wefP/sBpybT4Jn/XTbkd8bpz9Nx3HvjFe95ztH7wwF7g" +
       "E0c/JdtTFx+j7LtBXB583H3lnf/gB//OS39QnmT6vzbglpLHMQAA");
}
