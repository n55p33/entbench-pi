package org.apache.batik.gvt.text;
public class ConcreteTextSelector implements org.apache.batik.gvt.Selector {
    private java.util.ArrayList listeners;
    private org.apache.batik.gvt.GraphicsNode selectionNode;
    private org.apache.batik.gvt.RootGraphicsNode selectionNodeRoot;
    public ConcreteTextSelector() { super(); }
    public void mouseClicked(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseDragged(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseEntered(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseExited(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseMoved(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        
    }
    public void mousePressed(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseReleased(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void keyPressed(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyPressed");
    }
    public void keyReleased(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyReleased");
    }
    public void keyTyped(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyTyped");
    }
    public void changeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        
    }
    public void changeCompleted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        if (selectionNode ==
              null) {
            return;
        }
        java.awt.Shape newShape =
          ((org.apache.batik.gvt.Selectable)
             selectionNode).
          getHighlightShape(
            );
        dispatchSelectionEvent(
          new org.apache.batik.gvt.event.SelectionEvent(
            getSelection(
              ),
            org.apache.batik.gvt.event.SelectionEvent.
              SELECTION_CHANGED,
            newShape));
    }
    public void setSelection(org.apache.batik.gvt.text.Mark begin,
                             org.apache.batik.gvt.text.Mark end) {
        org.apache.batik.gvt.TextNode node =
          begin.
          getTextNode(
            );
        if (node !=
              end.
              getTextNode(
                )) {
            throw new java.lang.Error(
              "Markers not from same TextNode");
        }
        node.
          setSelection(
            begin,
            end);
        selectionNode =
          node;
        selectionNodeRoot =
          node.
            getRoot(
              );
        java.lang.Object selection =
          getSelection(
            );
        java.awt.Shape shape =
          node.
          getHighlightShape(
            );
        dispatchSelectionEvent(
          new org.apache.batik.gvt.event.SelectionEvent(
            selection,
            org.apache.batik.gvt.event.SelectionEvent.
              SELECTION_DONE,
            shape));
    }
    public void clearSelection() { if (selectionNode ==
                                         null) {
                                       return;
                                   }
                                   dispatchSelectionEvent(
                                     new org.apache.batik.gvt.event.SelectionEvent(
                                       null,
                                       org.apache.batik.gvt.event.SelectionEvent.
                                         SELECTION_CLEARED,
                                       null));
                                   selectionNode =
                                     null;
                                   selectionNodeRoot =
                                     null;
    }
    protected void checkSelectGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        org.apache.batik.gvt.event.GraphicsNodeMouseEvent mevt =
          null;
        if (evt instanceof org.apache.batik.gvt.event.GraphicsNodeMouseEvent) {
            mevt =
              (org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
                evt;
        }
        org.apache.batik.gvt.GraphicsNode source =
          evt.
          getGraphicsNode(
            );
        if (isDeselectGesture(
              evt)) {
            if (selectionNode !=
                  null) {
                selectionNodeRoot.
                  removeTreeGraphicsNodeChangeListener(
                    this);
            }
            clearSelection(
              );
        }
        else
            if (mevt !=
                  null) {
                java.awt.geom.Point2D p =
                  new java.awt.geom.Point2D.Double(
                  mevt.
                    getX(
                      ),
                  mevt.
                    getY(
                      ));
                java.awt.geom.AffineTransform t =
                  source.
                  getGlobalTransform(
                    );
                if (t ==
                      null) {
                    t =
                      new java.awt.geom.AffineTransform(
                        );
                }
                else {
                    try {
                        t =
                          t.
                            createInverse(
                              );
                    }
                    catch (java.awt.geom.NoninvertibleTransformException ni) {
                        
                    }
                }
                p =
                  t.
                    transform(
                      p,
                      null);
                if (source instanceof org.apache.batik.gvt.Selectable &&
                      isSelectStartGesture(
                        evt)) {
                    if (selectionNode !=
                          source) {
                        if (selectionNode !=
                              null) {
                            selectionNodeRoot.
                              removeTreeGraphicsNodeChangeListener(
                                this);
                        }
                        selectionNode =
                          source;
                        if (source !=
                              null) {
                            selectionNodeRoot =
                              source.
                                getRoot(
                                  );
                            selectionNodeRoot.
                              addTreeGraphicsNodeChangeListener(
                                this);
                        }
                    }
                    ((org.apache.batik.gvt.Selectable)
                       source).
                      selectAt(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                    dispatchSelectionEvent(
                      new org.apache.batik.gvt.event.SelectionEvent(
                        null,
                        org.apache.batik.gvt.event.SelectionEvent.
                          SELECTION_STARTED,
                        null));
                }
                else
                    if (isSelectEndGesture(
                          evt)) {
                        if (selectionNode ==
                              source) {
                            ((org.apache.batik.gvt.Selectable)
                               source).
                              selectTo(
                                p.
                                  getX(
                                    ),
                                p.
                                  getY(
                                    ));
                        }
                        java.lang.Object oldSelection =
                          getSelection(
                            );
                        if (selectionNode !=
                              null) {
                            java.awt.Shape newShape;
                            newShape =
                              ((org.apache.batik.gvt.Selectable)
                                 selectionNode).
                                getHighlightShape(
                                  );
                            dispatchSelectionEvent(
                              new org.apache.batik.gvt.event.SelectionEvent(
                                oldSelection,
                                org.apache.batik.gvt.event.SelectionEvent.
                                  SELECTION_DONE,
                                newShape));
                        }
                    }
                    else
                        if (isSelectContinueGesture(
                              evt)) {
                            if (selectionNode ==
                                  source) {
                                boolean result =
                                  ((org.apache.batik.gvt.Selectable)
                                     source).
                                  selectTo(
                                    p.
                                      getX(
                                        ),
                                    p.
                                      getY(
                                        ));
                                if (result) {
                                    java.awt.Shape newShape =
                                      ((org.apache.batik.gvt.Selectable)
                                         selectionNode).
                                      getHighlightShape(
                                        );
                                    dispatchSelectionEvent(
                                      new org.apache.batik.gvt.event.SelectionEvent(
                                        null,
                                        org.apache.batik.gvt.event.SelectionEvent.
                                          SELECTION_CHANGED,
                                        newShape));
                                }
                            }
                        }
                        else
                            if (source instanceof org.apache.batik.gvt.Selectable &&
                                  isSelectAllGesture(
                                    evt)) {
                                if (selectionNode !=
                                      source) {
                                    if (selectionNode !=
                                          null) {
                                        selectionNodeRoot.
                                          removeTreeGraphicsNodeChangeListener(
                                            this);
                                    }
                                    selectionNode =
                                      source;
                                    if (source !=
                                          null) {
                                        selectionNodeRoot =
                                          source.
                                            getRoot(
                                              );
                                        selectionNodeRoot.
                                          addTreeGraphicsNodeChangeListener(
                                            this);
                                    }
                                }
                                ((org.apache.batik.gvt.Selectable)
                                   source).
                                  selectAll(
                                    p.
                                      getX(
                                        ),
                                    p.
                                      getY(
                                        ));
                                java.lang.Object oldSelection =
                                  getSelection(
                                    );
                                java.awt.Shape newShape =
                                  ((org.apache.batik.gvt.Selectable)
                                     source).
                                  getHighlightShape(
                                    );
                                dispatchSelectionEvent(
                                  new org.apache.batik.gvt.event.SelectionEvent(
                                    oldSelection,
                                    org.apache.batik.gvt.event.SelectionEvent.
                                      SELECTION_DONE,
                                    newShape));
                            }
            }
    }
    private boolean isDeselectGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_CLICKED &&
          ((org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
             evt).
          getClickCount(
            ) ==
          1;
    }
    private boolean isSelectStartGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_PRESSED;
    }
    private boolean isSelectEndGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_RELEASED;
    }
    private boolean isSelectContinueGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_DRAGGED;
    }
    private boolean isSelectAllGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_CLICKED &&
          ((org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
             evt).
          getClickCount(
            ) ==
          2;
    }
    public java.lang.Object getSelection() {
        java.lang.Object value =
          null;
        if (selectionNode instanceof org.apache.batik.gvt.Selectable) {
            value =
              ((org.apache.batik.gvt.Selectable)
                 selectionNode).
                getSelection(
                  );
        }
        return value;
    }
    public boolean isEmpty() { return getSelection(
                                        ) ==
                                 null; }
    public void dispatchSelectionEvent(org.apache.batik.gvt.event.SelectionEvent e) {
        if (listeners !=
              null) {
            java.util.Iterator iter =
              listeners.
              iterator(
                );
            switch (e.
                      getID(
                        )) {
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_DONE:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionDone(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_CHANGED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionChanged(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_CLEARED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionCleared(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_STARTED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionStarted(
                            e);
                    }
                    break;
            }
        }
    }
    public void addSelectionListener(org.apache.batik.gvt.event.SelectionListener l) {
        if (listeners ==
              null) {
            listeners =
              new java.util.ArrayList(
                );
        }
        listeners.
          add(
            l);
    }
    public void removeSelectionListener(org.apache.batik.gvt.event.SelectionListener l) {
        if (listeners !=
              null) {
            listeners.
              remove(
                l);
        }
    }
    private void report(org.apache.batik.gvt.event.GraphicsNodeEvent evt,
                        java.lang.String message) {
        org.apache.batik.gvt.GraphicsNode source =
          evt.
          getGraphicsNode(
            );
        java.lang.String label =
          "(non-text node)";
        if (source instanceof org.apache.batik.gvt.TextNode) {
            char[] cbuff;
            java.text.CharacterIterator iter =
              ((org.apache.batik.gvt.TextNode)
                 source).
              getAttributedCharacterIterator(
                );
            cbuff =
              (new char[iter.
                          getEndIndex(
                            )]);
            if (cbuff.
                  length >
                  0)
                cbuff[0] =
                  iter.
                    first(
                      );
            for (int i =
                   1;
                 i <
                   cbuff.
                     length;
                 ++i) {
                cbuff[i] =
                  iter.
                    next(
                      );
            }
            label =
              new java.lang.String(
                cbuff);
        }
        java.lang.System.
          out.
          println(
            "Mouse " +
            message +
            " in " +
            label);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "33dEpvBXfGv8D59KR6nSNwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oDlCxU1R480NvOiQHFJbtblUpobeXE3E");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "9k/e+JlPfmN7QOb/AcuxiyKdQgAA");
}
