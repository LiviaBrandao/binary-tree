package com.company;

import java.io.Serializable;
import java.lang.reflect.Method;

public class MyOrderedLinkedList<X extends Comparable<X>> implements Serializable {

    protected class Node implements Serializable {

        private X info;
        private Node next;

        public Node (X i, Node nxt) {
            this.info = i;
            this.next = nxt;
        }

        public Node (X i) {
            this.info = i;
            this.next = null;
        }

        public X getIndex() {
            return this.info;
        }

        public Node getNext() {
            return this.next;
        }

        public void setIndex(X i) {
            this.info = i;
        }

        public void setNext(Node nxt) {
            this.next = nxt;
        }

    }

    protected Node frst, last, indx;

    public MyOrderedLinkedList() {
        this.frst = this.last = this.indx = null;
    }

    protected X meuCloneDeX (X x) {
        X ret=null;

        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tiposDosParms = null; // null pq clone nao tem parametros
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null; // null pq clone nao tem parametros
            ret = (X)metodo.invoke(x,parms);
        }
        catch (Exception erro)
        {} // pq sei que estou chamando clone de um objeto que � Cloneable e, portanto, nao h� risco do m�todo n�o existir ou de ser chamado com parametros errado

        return ret;
    }

    public void removeFromTheTop(X i) throws Exception {
        if (i==null)
            throw new Exception("Nothing passed");

        X info;
        if (i instanceof Cloneable)
            info = meuCloneDeX(i);
        else
            info = i;

        if (this.frst==null) {
            this.frst = this.last = new Node(info,null);
            return;
        }

        int comp=info.compareTo(this.frst.getIndex());

        if (comp<0) {
            this.frst = new Node(info,this.frst);
            return;
        }

        if (comp==0)
            throw new Exception ("This already exists");

        Node indx=this.frst;

        for(;;) {
            if (indx.getNext()==null)
                break;
            comp=i.compareTo(indx.getNext().getIndex());
            if (comp==0)
                throw new Exception ("Informacao repetida");
            if (comp<0)
                break;

            indx=indx.getNext();
        }

        indx.setNext (new Node (info,indx.getNext()));

        if(this.last.getNext() != null)
            this.last = this.last.getNext();
    }

    public X removeFromTheTop() {
        Node aux = this.frst;
        this.frst = this.frst.getNext();

        return aux.info;
    }


    public boolean hasThis(X i) throws Exception {
        if (i==null)
            throw new Exception("Missing information");

        Node indx = this.frst;

        while (indx!=null) {
            if (i.equals(indx.getIndex()))
                return true;
            indx = indx.getNext();
        }

        return false;
    }

    public int getCount() {
        int ret = 0;
        Node indx = this.frst;

        while (indx!=null) {
            ret++;
            indx = indx.getNext();
        }
        return ret;
    }

    public X getFromTheTop() throws Exception {
        if (this.frst==null)
            throw new Exception ("Nothing to retrieve");
        X ret = this.frst.getIndex();

        if (ret instanceof Cloneable)
            ret = meuCloneDeX(ret);

        return ret;
    }

    public X getCurrent() {
        if(this.indx == null)
            this.first();

        return this.indx.getIndex();
    }

    public X getFromTheBottom() throws Exception {
        if (this.frst==null)
            throw new Exception("Nothing to retrieve");

        X ret = this.last.getIndex();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);

        return ret;
    }

    public boolean next() {
        if(this.isEmpty())
            return false;
        if(this.indx == null)
            return false;
        if(this.indx == this.last)
            return false;

        this.indx = this.indx.getNext();

        return true;

    }

    public boolean first() {
        this.indx = this.frst;
        return this.indx != null;
    }

    public boolean isEmpty() {
        return this.frst==null;
    }

    public String toString() {
        String ret = "\n[";
        Node indx = this.frst;

        while(indx!=null) {
            ret=ret+indx.getIndex();
            if (indx!=this.last)
                ret=ret+",";

            indx=indx.getNext();
        }

        return ret+"]\n";
    }

    public boolean equals (Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (this.getClass()!= obj.getClass())
            return false;

        MyOrderedLinkedList<X> list = (MyOrderedLinkedList<X>)obj;
        Node currentThis = this.frst;
        Node currentList = list.frst;

        while (currentThis!=null && currentList!=null) {
            if (!currentThis.getIndex().equals(currentList.getIndex()))
                return false;
            currentThis  = currentThis.getNext();
            currentList = currentList.getNext();
        }

        if (currentThis!=null)
            return false;
        if (currentList!=null)
            return false;

        return true;
    }

    public int hashCode () {
        final int primeNumber = 13;

        int ret=666;

        for (Node indx=this.frst;
             indx!=null;
             indx=indx.getNext())
            ret = 17*ret + indx.getIndex().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    // construtor de copia
    public MyOrderedLinkedList(MyOrderedLinkedList<X> model) throws Exception {
        if (model==null)
            throw new Exception ("Modelo ausente");
        if (model.frst==null)
            return;

        this.frst = new Node(model.frst.getIndex());
        Node currentThis = this.frst;
        Node currentModel = model.frst.getNext();

        while (currentModel!=null) {
            currentThis.setNext(new Node(currentModel.getIndex()));
            currentThis = currentThis.getNext ();
            currentModel = currentModel.getNext ();
        }
        this.last = currentThis;
    }

    public Object clone () {
        MyOrderedLinkedList<X> ret=null;

        try {
            ret = new MyOrderedLinkedList(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
