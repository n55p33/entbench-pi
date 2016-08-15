package org.apache.batik.gvt;
public abstract class AbstractGraphicsNode implements org.apache.batik.gvt.GraphicsNode {
    protected javax.swing.event.EventListenerList listeners;
    protected java.awt.geom.AffineTransform transform;
    protected java.awt.geom.AffineTransform inverseTransform;
    protected java.awt.Composite composite;
    protected boolean isVisible = true;
    protected org.apache.batik.ext.awt.image.renderable.ClipRable clip;
    protected java.awt.RenderingHints hints;
    protected org.apache.batik.gvt.CompositeGraphicsNode parent;
    protected org.apache.batik.gvt.RootGraphicsNode root;
    protected org.apache.batik.gvt.filter.Mask mask;
    protected org.apache.batik.ext.awt.image.renderable.Filter filter;
    protected int pointerEventType = VISIBLE_PAINTED;
    protected java.lang.ref.WeakReference graphicsNodeRable;
    protected java.lang.ref.WeakReference enableBackgroundGraphicsNodeRable;
    protected java.lang.ref.WeakReference weakRef;
    private java.awt.geom.Rectangle2D bounds;
    protected org.apache.batik.gvt.event.GraphicsNodeChangeEvent changeStartedEvent =
      null;
    protected org.apache.batik.gvt.event.GraphicsNodeChangeEvent changeCompletedEvent =
      null;
    protected AbstractGraphicsNode() { super(); }
    public java.lang.ref.WeakReference getWeakReference() {
        if (weakRef ==
              null)
            weakRef =
              new java.lang.ref.WeakReference(
                this);
        return weakRef;
    }
    public int getPointerEventType() { return pointerEventType;
    }
    public void setPointerEventType(int pointerEventType) {
        this.
          pointerEventType =
          pointerEventType;
    }
    public void setTransform(java.awt.geom.AffineTransform newTransform) {
        fireGraphicsNodeChangeStarted(
          );
        this.
          transform =
          newTransform;
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        if (parent !=
              null)
            parent.
              invalidateGeometryCache(
                );
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getTransform() {
        return transform;
    }
    public java.awt.geom.AffineTransform getInverseTransform() {
        return inverseTransform;
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        java.awt.geom.AffineTransform ctm =
          new java.awt.geom.AffineTransform(
          );
        org.apache.batik.gvt.GraphicsNode node =
          this;
        while (node !=
                 null) {
            if (node.
                  getTransform(
                    ) !=
                  null) {
                ctm.
                  preConcatenate(
                    node.
                      getTransform(
                        ));
            }
            node =
              node.
                getParent(
                  );
        }
        return ctm;
    }
    public void setComposite(java.awt.Composite newComposite) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          composite =
          newComposite;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.Composite getComposite() { return composite;
    }
    public void setVisible(boolean isVisible) { fireGraphicsNodeChangeStarted(
                                                  );
                                                this.isVisible =
                                                  isVisible;
                                                invalidateGeometryCache(
                                                  );
                                                fireGraphicsNodeChangeCompleted(
                                                  ); }
    public boolean isVisible() { return isVisible; }
    public void setClip(org.apache.batik.ext.awt.image.renderable.ClipRable newClipper) {
        if (newClipper ==
              null &&
              this.
                clip ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          clip =
          newClipper;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.ext.awt.image.renderable.ClipRable getClip() {
        return clip;
    }
    public void setRenderingHint(java.awt.RenderingHints.Key key,
                                 java.lang.Object value) {
        fireGraphicsNodeChangeStarted(
          );
        if (this.
              hints ==
              null) {
            this.
              hints =
              new java.awt.RenderingHints(
                key,
                value);
        }
        else {
            hints.
              put(
                key,
                value);
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public void setRenderingHints(java.util.Map hints) {
        fireGraphicsNodeChangeStarted(
          );
        if (this.
              hints ==
              null) {
            this.
              hints =
              new java.awt.RenderingHints(
                hints);
        }
        else {
            this.
              hints.
              putAll(
                hints);
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public void setRenderingHints(java.awt.RenderingHints newHints) {
        fireGraphicsNodeChangeStarted(
          );
        hints =
          newHints;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.RenderingHints getRenderingHints() {
        return hints;
    }
    public void setMask(org.apache.batik.gvt.filter.Mask newMask) {
        if (newMask ==
              null &&
              mask ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        mask =
          newMask;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.gvt.filter.Mask getMask() {
        return mask;
    }
    public void setFilter(org.apache.batik.ext.awt.image.renderable.Filter newFilter) {
        if (newFilter ==
              null &&
              filter ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        filter =
          newFilter;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getFilter() {
        return filter;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getGraphicsNodeRable(boolean createIfNeeded) {
        org.apache.batik.gvt.filter.GraphicsNodeRable ret =
          null;
        if (graphicsNodeRable !=
              null) {
            ret =
              (org.apache.batik.gvt.filter.GraphicsNodeRable)
                graphicsNodeRable.
                get(
                  );
            if (ret !=
                  null)
                return ret;
        }
        if (createIfNeeded) {
            ret =
              new org.apache.batik.gvt.filter.GraphicsNodeRable8Bit(
                this);
            graphicsNodeRable =
              new java.lang.ref.WeakReference(
                ret);
        }
        return ret;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getEnableBackgroundGraphicsNodeRable(boolean createIfNeeded) {
        org.apache.batik.gvt.filter.GraphicsNodeRable ret =
          null;
        if (enableBackgroundGraphicsNodeRable !=
              null) {
            ret =
              (org.apache.batik.gvt.filter.GraphicsNodeRable)
                enableBackgroundGraphicsNodeRable.
                get(
                  );
            if (ret !=
                  null)
                return ret;
        }
        if (createIfNeeded) {
            ret =
              new org.apache.batik.gvt.filter.GraphicsNodeRable8Bit(
                this);
            ret.
              setUsePrimitivePaint(
                false);
            enableBackgroundGraphicsNodeRable =
              new java.lang.ref.WeakReference(
                ret);
        }
        return ret;
    }
    public void paint(java.awt.Graphics2D g2d) {
        if (composite !=
              null &&
              composite instanceof java.awt.AlphaComposite) {
            java.awt.AlphaComposite ac =
              (java.awt.AlphaComposite)
                composite;
            if (ac.
                  getAlpha(
                    ) <
                  0.001)
                return;
        }
        java.awt.geom.Rectangle2D bounds =
          getBounds(
            );
        if (bounds ==
              null)
            return;
        java.awt.Composite defaultComposite =
          null;
        java.awt.geom.AffineTransform defaultTransform =
          null;
        java.awt.RenderingHints defaultHints =
          null;
        java.awt.Graphics2D baseG2d =
          null;
        if (clip !=
              null) {
            baseG2d =
              g2d;
            g2d =
              (java.awt.Graphics2D)
                g2d.
                create(
                  );
            if (hints !=
                  null)
                g2d.
                  addRenderingHints(
                    hints);
            if (transform !=
                  null)
                g2d.
                  transform(
                    transform);
            if (composite !=
                  null)
                g2d.
                  setComposite(
                    composite);
            g2d.
              clip(
                clip.
                  getClipPath(
                    ));
        }
        else {
            if (hints !=
                  null) {
                defaultHints =
                  g2d.
                    getRenderingHints(
                      );
                g2d.
                  addRenderingHints(
                    hints);
            }
            if (transform !=
                  null) {
                defaultTransform =
                  g2d.
                    getTransform(
                      );
                g2d.
                  transform(
                    transform);
            }
            if (composite !=
                  null) {
                defaultComposite =
                  g2d.
                    getComposite(
                      );
                g2d.
                  setComposite(
                    composite);
            }
        }
        java.awt.Shape curClip =
          g2d.
          getClip(
            );
        g2d.
          setRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_AREA_OF_INTEREST,
            curClip);
        boolean paintNeeded =
          true;
        java.awt.Shape g2dClip =
          curClip;
        if (g2dClip !=
              null) {
            java.awt.geom.Rectangle2D cb =
              g2dClip.
              getBounds2D(
                );
            if (!bounds.
                  intersects(
                    cb.
                      getX(
                        ),
                    cb.
                      getY(
                        ),
                    cb.
                      getWidth(
                        ),
                    cb.
                      getHeight(
                        )))
                paintNeeded =
                  false;
        }
        if (paintNeeded) {
            boolean antialiasedClip =
              false;
            if (clip !=
                  null &&
                  clip.
                  getUseAntialiasedClip(
                    )) {
                antialiasedClip =
                  isAntialiasedClip(
                    g2d.
                      getTransform(
                        ),
                    g2d.
                      getRenderingHints(
                        ),
                    clip.
                      getClipPath(
                        ));
            }
            boolean useOffscreen =
              isOffscreenBufferNeeded(
                );
            useOffscreen |=
              antialiasedClip;
            if (!useOffscreen) {
                primitivePaint(
                  g2d);
            }
            else {
                org.apache.batik.ext.awt.image.renderable.Filter filteredImage =
                  null;
                if (filter ==
                      null) {
                    filteredImage =
                      getGraphicsNodeRable(
                        true);
                }
                else {
                    filteredImage =
                      filter;
                }
                if (mask !=
                      null) {
                    if (mask.
                          getSource(
                            ) !=
                          filteredImage) {
                        mask.
                          setSource(
                            filteredImage);
                    }
                    filteredImage =
                      mask;
                }
                if (clip !=
                      null &&
                      antialiasedClip) {
                    if (clip.
                          getSource(
                            ) !=
                          filteredImage) {
                        clip.
                          setSource(
                            filteredImage);
                    }
                    filteredImage =
                      clip;
                }
                baseG2d =
                  g2d;
                g2d =
                  (java.awt.Graphics2D)
                    g2d.
                    create(
                      );
                if (antialiasedClip) {
                    g2d.
                      setClip(
                        null);
                }
                java.awt.geom.Rectangle2D filterBounds =
                  filteredImage.
                  getBounds2D(
                    );
                g2d.
                  clip(
                    filterBounds);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    filteredImage);
                g2d.
                  dispose(
                    );
                g2d =
                  baseG2d;
                baseG2d =
                  null;
            }
        }
        if (baseG2d !=
              null) {
            g2d.
              dispose(
                );
        }
        else {
            if (defaultHints !=
                  null)
                g2d.
                  setRenderingHints(
                    defaultHints);
            if (defaultTransform !=
                  null)
                g2d.
                  setTransform(
                    defaultTransform);
            if (defaultComposite !=
                  null) {
                g2d.
                  setComposite(
                    defaultComposite);
            }
        }
    }
    private void traceFilter(org.apache.batik.ext.awt.image.renderable.Filter filter,
                             java.lang.String prefix) {
        java.lang.System.
          out.
          println(
            prefix +
            filter.
              getClass(
                ).
              getName(
                ));
        java.lang.System.
          out.
          println(
            prefix +
            filter.
              getBounds2D(
                ));
        java.util.List sources =
          filter.
          getSources(
            );
        int nSources =
          sources !=
          null
          ? sources.
          size(
            )
          : 0;
        prefix +=
          "\t";
        for (int i =
               0;
             i <
               nSources;
             i++) {
            org.apache.batik.ext.awt.image.renderable.Filter source =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                sources.
                get(
                  i);
            traceFilter(
              source,
              prefix);
        }
        java.lang.System.
          out.
          flush(
            );
    }
    protected boolean isOffscreenBufferNeeded() {
        return filter !=
          null ||
          mask !=
          null ||
          composite !=
          null &&
          !java.awt.AlphaComposite.
             SrcOver.
          equals(
            composite);
    }
    protected boolean isAntialiasedClip(java.awt.geom.AffineTransform usr2dev,
                                        java.awt.RenderingHints hints,
                                        java.awt.Shape clip) {
        if (clip ==
              null)
            return false;
        java.lang.Object val =
          hints.
          get(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_TRANSCODING);
        if (val ==
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_PRINTING ||
              val ==
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_VECTOR)
            return false;
        if (!(clip instanceof java.awt.geom.Rectangle2D &&
                usr2dev.
                getShearX(
                  ) ==
                0 &&
                usr2dev.
                getShearY(
                  ) ==
                0))
            return true;
        return false;
    }
    public void fireGraphicsNodeChangeStarted(org.apache.batik.gvt.GraphicsNode changeSrc) {
        if (changeStartedEvent ==
              null)
            changeStartedEvent =
              new org.apache.batik.gvt.event.GraphicsNodeChangeEvent(
                this,
                org.apache.batik.gvt.event.GraphicsNodeChangeEvent.
                  CHANGE_STARTED);
        changeStartedEvent.
          setChangeSrc(
            changeSrc);
        fireGraphicsNodeChangeStarted(
          changeStartedEvent);
        changeStartedEvent.
          setChangeSrc(
            null);
    }
    public void fireGraphicsNodeChangeStarted() {
        if (changeStartedEvent ==
              null)
            changeStartedEvent =
              new org.apache.batik.gvt.event.GraphicsNodeChangeEvent(
                this,
                org.apache.batik.gvt.event.GraphicsNodeChangeEvent.
                  CHANGE_STARTED);
        else {
            changeStartedEvent.
              setChangeSrc(
                null);
        }
        fireGraphicsNodeChangeStarted(
          changeStartedEvent);
    }
    public void fireGraphicsNodeChangeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent changeStartedEvent) {
        org.apache.batik.gvt.RootGraphicsNode rootGN =
          getRoot(
            );
        if (rootGN ==
              null)
            return;
        java.util.List l =
          rootGN.
          getTreeGraphicsNodeChangeListeners(
            );
        if (l ==
              null)
            return;
        java.util.Iterator i =
          l.
          iterator(
            );
        org.apache.batik.gvt.event.GraphicsNodeChangeListener gncl;
        while (i.
                 hasNext(
                   )) {
            gncl =
              (org.apache.batik.gvt.event.GraphicsNodeChangeListener)
                i.
                next(
                  );
            gncl.
              changeStarted(
                changeStartedEvent);
        }
    }
    public void fireGraphicsNodeChangeCompleted() {
        if (changeCompletedEvent ==
              null) {
            changeCompletedEvent =
              new org.apache.batik.gvt.event.GraphicsNodeChangeEvent(
                this,
                org.apache.batik.gvt.event.GraphicsNodeChangeEvent.
                  CHANGE_COMPLETED);
        }
        org.apache.batik.gvt.RootGraphicsNode rootGN =
          getRoot(
            );
        if (rootGN ==
              null)
            return;
        java.util.List l =
          rootGN.
          getTreeGraphicsNodeChangeListeners(
            );
        if (l ==
              null)
            return;
        java.util.Iterator i =
          l.
          iterator(
            );
        org.apache.batik.gvt.event.GraphicsNodeChangeListener gncl;
        while (i.
                 hasNext(
                   )) {
            gncl =
              (org.apache.batik.gvt.event.GraphicsNodeChangeListener)
                i.
                next(
                  );
            gncl.
              changeCompleted(
                changeCompletedEvent);
        }
    }
    public org.apache.batik.gvt.CompositeGraphicsNode getParent() {
        return parent;
    }
    public org.apache.batik.gvt.RootGraphicsNode getRoot() {
        return root;
    }
    protected void setRoot(org.apache.batik.gvt.RootGraphicsNode newRoot) {
        this.
          root =
          newRoot;
    }
    protected void setParent(org.apache.batik.gvt.CompositeGraphicsNode newParent) {
        this.
          parent =
          newParent;
    }
    protected void invalidateGeometryCache() {
        if (parent !=
              null) {
            parent.
              invalidateGeometryCache(
                );
        }
        bounds =
          null;
    }
    public java.awt.geom.Rectangle2D getBounds() {
        if (bounds ==
              null) {
            if (filter ==
                  null) {
                bounds =
                  getPrimitiveBounds(
                    );
            }
            else {
                bounds =
                  filter.
                    getBounds2D(
                      );
            }
            if (bounds !=
                  null) {
                if (clip !=
                      null) {
                    java.awt.geom.Rectangle2D clipR =
                      clip.
                      getClipPath(
                        ).
                      getBounds2D(
                        );
                    if (clipR.
                          intersects(
                            bounds))
                        java.awt.geom.Rectangle2D.
                          intersect(
                            bounds,
                            clipR,
                            bounds);
                }
                if (mask !=
                      null) {
                    java.awt.geom.Rectangle2D maskR =
                      mask.
                      getBounds2D(
                        );
                    if (maskR.
                          intersects(
                            bounds))
                        java.awt.geom.Rectangle2D.
                          intersect(
                            bounds,
                            maskR,
                            bounds);
                }
            }
            bounds =
              normalizeRectangle(
                bounds);
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    )) {
                invalidateGeometryCache(
                  );
            }
        }
        return bounds;
    }
    public java.awt.geom.Rectangle2D getTransformedBounds(java.awt.geom.AffineTransform txf) {
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        java.awt.geom.Rectangle2D tBounds =
          null;
        if (filter ==
              null) {
            tBounds =
              getTransformedPrimitiveBounds(
                txf);
        }
        else {
            tBounds =
              t.
                createTransformedShape(
                  filter.
                    getBounds2D(
                      )).
                getBounds2D(
                  );
        }
        if (tBounds !=
              null) {
            if (clip !=
                  null) {
                java.awt.geom.Rectangle2D.
                  intersect(
                    tBounds,
                    t.
                      createTransformedShape(
                        clip.
                          getClipPath(
                            )).
                      getBounds2D(
                        ),
                    tBounds);
            }
            if (mask !=
                  null) {
                java.awt.geom.Rectangle2D.
                  intersect(
                    tBounds,
                    t.
                      createTransformedShape(
                        mask.
                          getBounds2D(
                            )).
                      getBounds2D(
                        ),
                    tBounds);
            }
        }
        return tBounds;
    }
    public java.awt.geom.Rectangle2D getTransformedPrimitiveBounds(java.awt.geom.AffineTransform txf) {
        java.awt.geom.Rectangle2D tpBounds =
          getPrimitiveBounds(
            );
        if (tpBounds ==
              null) {
            return null;
        }
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        return t.
          createTransformedShape(
            tpBounds).
          getBounds2D(
            );
    }
    public java.awt.geom.Rectangle2D getTransformedGeometryBounds(java.awt.geom.AffineTransform txf) {
        java.awt.geom.Rectangle2D tpBounds =
          getGeometryBounds(
            );
        if (tpBounds ==
              null) {
            return null;
        }
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        return t.
          createTransformedShape(
            tpBounds).
          getBounds2D(
            );
    }
    public java.awt.geom.Rectangle2D getTransformedSensitiveBounds(java.awt.geom.AffineTransform txf) {
        java.awt.geom.Rectangle2D sBounds =
          getSensitiveBounds(
            );
        if (sBounds ==
              null) {
            return null;
        }
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        return t.
          createTransformedShape(
            sBounds).
          getBounds2D(
            );
    }
    public boolean contains(java.awt.geom.Point2D p) {
        java.awt.geom.Rectangle2D b =
          getSensitiveBounds(
            );
        if (b ==
              null ||
              !b.
              contains(
                p)) {
            return false;
        }
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case VISIBLE_FILL:
            case VISIBLE_STROKE:
            case VISIBLE:
                return isVisible;
            case PAINTED:
            case FILL:
            case STROKE:
            case ALL:
                return true;
            case NONE:
            default:
                return false;
        }
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        java.awt.geom.Rectangle2D b =
          getBounds(
            );
        if (b ==
              null)
            return false;
        return b.
          intersects(
            r);
    }
    public org.apache.batik.gvt.GraphicsNode nodeHitAt(java.awt.geom.Point2D p) {
        return contains(
                 p)
          ? this
          : null;
    }
    static double EPSILON = 1.0E-6;
    protected java.awt.geom.Rectangle2D normalizeRectangle(java.awt.geom.Rectangle2D bounds) {
        if (bounds ==
              null)
            return null;
        if (bounds.
              getWidth(
                ) <
              EPSILON) {
            if (bounds.
                  getHeight(
                    ) <
                  EPSILON) {
                java.awt.geom.AffineTransform gt =
                  getGlobalTransform(
                    );
                double det =
                  java.lang.Math.
                  sqrt(
                    gt.
                      getDeterminant(
                        ));
                return new java.awt.geom.Rectangle2D.Double(
                  bounds.
                    getX(
                      ),
                  bounds.
                    getY(
                      ),
                  EPSILON /
                    det,
                  EPSILON /
                    det);
            }
            else {
                double tmpW =
                  bounds.
                  getHeight(
                    ) *
                  EPSILON;
                if (tmpW <
                      bounds.
                      getWidth(
                        ))
                    tmpW =
                      bounds.
                        getWidth(
                          );
                return new java.awt.geom.Rectangle2D.Double(
                  bounds.
                    getX(
                      ),
                  bounds.
                    getY(
                      ),
                  tmpW,
                  bounds.
                    getHeight(
                      ));
            }
        }
        else
            if (bounds.
                  getHeight(
                    ) <
                  EPSILON) {
                double tmpH =
                  bounds.
                  getWidth(
                    ) *
                  EPSILON;
                if (tmpH <
                      bounds.
                      getHeight(
                        ))
                    tmpH =
                      bounds.
                        getHeight(
                          );
                return new java.awt.geom.Rectangle2D.Double(
                  bounds.
                    getX(
                      ),
                  bounds.
                    getY(
                      ),
                  bounds.
                    getWidth(
                      ),
                  tmpH);
            }
        return bounds;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZTX0onJehH0QGPseu8W7W/8f1v5wbeRYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8EIsKlDbq3YZmsFLAUXjpfGQLdhWxMxq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HtAub+LbPVmqjqLSbOo5ejVkIqdtsa4iwmVFbk2SCYOx/aIm4aMujzmD4dwH" +
       "A4+G467HeRtjyWXdHeabK8wTlsWBvsbp0TpaaEN14iqSFqpYI6kqXbtAjVjN" +
       "KoSY7basCMUrTLweMLWOjXb1Htx3mD4dwSiqIQtnqpcJZ5AUlotpN/KWeZ9u" +
       "ByENd5PuqDW1/IKpSkazYQ3F/qq3nq5HFQyLO0yr5iMzkhj0e/ZAWVIqumSR" +
       "1XrUhpQaw1qzOKBXMe4jRboHlYPWEB04cxXHx3oyF8UisWjm03wNmnIXNpC2" +
       "NZBWoWhNdZsKiqNaP1mPFdJiHK6dSDjcnjDoBJsHnXjchjyYGSAlPMInbkeZ" +
       "mhE9SRYzOSKUWZnotEVB760Nree0vQRl9FmrPo2JcqNLIWEnqKzQFrdch22/" +
       "YeV9k84rEKoAuYV43GgvyDy6aohRv6G2Z+ZwFthC0RBHgyjssnyTXPfnSCXi" +
       "03x2hgOVJ+Q4aS/hFiZ1UYwKkqSGN2dNF+11W2tzQszweQHVqhrFS/JMKA2A" +
       "cZbWDCFCVa/O+vnxmEVMJvTgPlFYMLUl1eOogTLQGqN2z3O5ebEDtayQtOBW" +
       "F5snQ0zsVLCuMXWLaw9KxF4gtG0/duCy2UxEDoHyQXnaJebEpFVosy1hysda" +
       "cSnVYZhYk+WSgvjrEbSEiqbWgxaYNGsSros0aW9SUctyLy/B5BLYvxATVBGr" +
       "qRQq6PQYBllZmooxtByvqirUKhKBWDaoaXdEcUG+ZXWgbo2ZhFU04mV8KNpm" +
       "d95I0Hx/qvCIKRpjs6lKGNFyO2C0ulJHATkcMRwlhtGQh51as0MvpxNNjdoU" +
       "plQcptzIj3qE2q2bAwXNj7R2l1YSx1zLAtJcJwbKF/rK0DIGy0IB6Utw3qLH" +
       "3VGP7RKFUGWDbjRNzLWIhJa/Cj3Q+9A11JtF3qC9HPJmYzpyaEVpr3qwONTY" +
       "UakfNXGnMGu2sMVIkrWiwjeWRhHoDimRyayLWHC/qamToTltaqbYUuJ+s4kw" +
       "+BLpDucyrtVIFZ4ojYgVq92EI+1ksO42u2wnmghIgeMYSoFbMGUwjqA0UaNi" +
       "TwsDsiR3YjEgrD4st43KQMQqqKUOwPi+imL1SManJdNuVmB+XBXJYUM2PZjw" +
       "KtOKDvfr9Ho56OoYUYm5qmhTZANGa4gxGMyb4yLTX7XLQ2G0njPUWrV0cxFa" +
       "+rINzyRvbPW8KSQ4Yxui3Iol17jaeiB3DaudiIseaWDcKmJEFxnMmdjTxy2U" +
       "j/WROSfjoNdz9ZDDjVETNqx5TDV7lOkNmuaKao2rnAsViFFLsiXNXZIUvWwm" +
       "3JiOg7quVXino/rrUCg5yxHkO4k+nbHFKakkpC5OGvyoj/uqBvcSYoRD3dkk" +
       "AeNOhBhQPaRn1FvacFV2Eayf9JyB0VJ0ny2hUZsoyuspXOjhiOu6jTonVmug" +
       "ExMJMKevbKuJzCZifcYmkefA3WrHKnSK+HzVVuSE0RCKU5qa68grliSlAhSV" +
       "F0q+785XU3SkN5qFKF7rIt5qjXpdBsKlHuxWB5FQbZTpaAq7RFfH63rHLVT7" +
       "bYlrFcaYsIAXnYYGaaN2YRLF+Q7RUnCYxQrtTkNY1vGAqcFDBuTNoooTXGcw" +
       "GzQUghuQYnEwq8nsqlKvt2bdBV1RYYxv1GO1UcPmBVHrGbjCVnrwfI3BhaXO" +
       "+OQgJFdtds3AgzHMNRp5xIpLdcXS6hGF1tAKsCs9D6866jiQhrEsooKQb6Ed" +
       "2zVZoJ4Yii0Vrepa44FaUgKl24/JHi0V1ImAroM511yALmy88GYQzc8XATaR" +
       "W2EHgkdYPHQbtaGL1wp21NMYdabaAWjEIbKKtuhyvQPV5bncWk3aam1upuH1" +
       "TqPSLPWrRFmZd5dozC5XVjKKsdmq2MuvrY4yGHITz2axkm8sDXbqB7xIOnWD" +
       "mMxaM9BlGinldtKsrx2sThqyblK1zLYWgbkgDCqKFh2pV9dlobAuamLYjkkw" +
       "wGkI9RrF9k2vEnabVdQKek4UzouxPO8mhIpHI7wvofHShh2+54XkGsRRpsN4" +
       "oFGL1rpaIeOhpM4lHdWr01m5oUlUqSczeq1WDKYWxS5RbihalB/phKk0uzo6" +
       "SkhrDgYjdomI8NZ0rUZmL1+RE6gZLWwFj9tFQiXm+fWKSgYMPtQWtqVDvXUH" +
       "7kZMI2+DwZvvDbvFpcBN5015BWNBMBPIfEkBasfjRqs0qK17hM5DfY0qlXB3" +
       "3OcwAvPpWexFfK+vaXaejpa9SiEKYork55RNOo0+1lyFI0UkCNQyum7eWi1Z" +
       "ZiQSbRReQd02ZMTiaCHH3lhD6bAhzAczrN3MF+NuF9R/Rh2u5qo5TOLuFG2L" +
       "8NIu4F2BalREq451ik5egOdEPGRX5LreCtV1mUbHBZ+o0lRYgK2+TdgI0Rp6" +
       "o367MbGdNsfDBjmXSC4RKiHlKOUayVq8siqCHkTbq9lTvZNwHX697AyTEeS5" +
       "vCOG4UIsI82BAHSNRisWMZ/W+2y5bKoDLeCh7tRwwlhXpYjq8pK6xBCMHFp0" +
       "go+IMdpFmfqsXi9MlMp4EhQHjKhb9cCn63B96ElxQceGMPihBQlWZrq9chlY" +
       "SpwNbVod45VaORGt1QQ0yqsJWxvWRlVv6ddob0ZTtToEV2i3IiEiXrerRclb" +
       "4EQdxO0n0yLB+aV1h6vxRW2FDzo45RXYsEu7a7m8wGCWr8xrlGzI3ixMuOKY" +
       "7TccpLhak/54VnMTlYmFnlwdh8m6B4cmvi7BLjLGzbga9Ml5r6t73WUH0zxD" +
       "YKy82PFcg8R6ZUfgCmOColWP688MfyaG/VIBhhxo0dQlR+FEsdIwmGK/XCnW" +
       "oFCg18UCyJe82Guai6E2d0eaJc0MaQmGvLTStuIZPh2pc1caUOO+IvaIarXb" +
       "niT8cso48JIiYJgb9cn2GptFqD1lm1VOW9uzmbuScHroA11Y+ToltLhVmZH6" +
       "CTCjvmjr3hpu1iMtBCNvSJmh9WVv0qz7K6lkC3TFgsaqUB3Ox1zBMgl5iReG" +
       "nYEnB7UpMoVqi2JYiQR5NGs0Go+nrxvvvLHXjc/N3qwebldb6Ujq8U838EYx" +
       "PvmBe9kD/dxt/Hb7ztEOiuzvrtzO/qdjb6+zkPdtd+5sX/E+dOIKgOPv/tNl" +
       "pA+ctpktW0L61Pd84KNS/yeLB2t2jHSVtGW/VpdDWT/20NeClB49fRUQle3l" +
       "O1pQ/1vf83/uH79h+V03sFPopTty7ib5Merjn+28Unz/Xm7/cHn9NbsMr470" +
       "2NWL6u9wZT9wzfFVS+sfOCyDF6ZZ/gi4PrQtgw/triA4UoGTFzh8c6NCmd+J" +
       "+0IuvfoMv0dT5+V+7rIi+1ete9pZfZOtdLjvmeTcrL451NdLDz/TG/Dj4qQ3" +
       "Lj14+MRUMbP14h/bPvFjF58z1TP8aqlT9HPPAzkz2Fm0l4b/xBFm6RyYWcbW" +
       "wfWpLeanLgbz0lGAT2Q8zTNY06VHlx4HrN61rCeudggtVTrif8N5+V8Hrl/Z" +
       "8v/KhfP3M8bhGfxM6pB+7tmA//h+h0vYESR1Dsh02Vq2neALW8gvXLwuv/kM" +
       "vydShwN8ytV8uf4R3+y8fKn/H2/5/vji+dQz/NJlypekTV3tnrRt5QhTPi/m" +
       "a8H1F1vMv7h4zOAMvyh1bD93N8Ds6JbA66dROuetkTC4/nZL+bcXXiOfyHDe" +
       "cQbqv06dt21q5PH9PMdr5NvPAfn89OZD4Pr2FvLbF1+U7znD7wdT512bGnnV" +
       "fqUnjvjefd5CBKp66ZZN3M3nhRailoF86AzIH0udD/i5O0AhbjdA7RThB8+B" +
       "+Lz05ouBMJe3iJcvvgh/8gy/n0qdHz++uyvLlSO4n7iI8rtnC3fPhZdflFH8" +
       "hzMIP5U6H/dzt6aVUFftncL7xHnrX1p4D235Hrr4wvvVM/z+U+r8IkBTDtFy" +
       "0RHaL5236DAg5Wu3aK+9GLS9zXgu+324aeHaTV4P9+TkIMyx1bGbTcIZ+2fP" +
       "yJf/ljr/BcQERX5Vujtl/xvnzaDXANbHtxn0+IXqdvb7aOSSDiFyrzjraQe5" +
       "9ZyjPeoUnyn7l7I8+aMz8uvLqfMHYPy+m1/eTob99wvoI18itwjkhRuDJzOa" +
       "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");
}
