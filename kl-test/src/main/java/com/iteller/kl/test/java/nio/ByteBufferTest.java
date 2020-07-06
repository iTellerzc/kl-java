package com.iteller.kl.test.java.nio;

import org.testng.annotations.Test;

import java.nio.ByteBuffer;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/30 19:54
 * description:
 */
public class ByteBufferTest {

    @Test
    public void testBuffer(){
        //notice offset
        int cap = 16;
        ByteBuffer bb = ByteBuffer.allocate(cap);
        System.out.println("init cap:" + bb.capacity());
        System.out.println("init limit:" + bb.limit());
        System.out.println("init pos:" + bb.position());

        //position add
       /* System.out.println("get before put:"  + bb.get());
        System.out.println("getInt before put:"  + bb.getInt());
        System.out.println("pos after get:" + bb.position());*/

        //bb.put((byte)(5));
        //ByteBuffer newBb =
        bb.putInt(1);
        //System.out.println(bb.array());
        System.out.println("pos after put:" + bb.position());

        /*for(byte b : bb.array()){
            System.out.println(b);
        }*/

        //System.out.println("bb:" + bb + ",new:" + newBb);

        System.out.println("get after put:"  + bb.get());
        System.out.println("pos after get:" + bb.position());
        System.out.println("getInt after put:"  + bb.getInt());
        System.out.println("pos after getInt:" + bb.position());

        //System.out.println("new get:"  + newBb.get());
        //System.out.println("new getInt:"  + newBb.getInt());

        //position=0, limit=capacity, mark=-1
        /*bb.clear();
        System.out.println("cap after clear:" + bb.capacity());
        System.out.println("limit after clear:" + bb.limit());
        System.out.println("pos after clear:" + bb.position());
        System.out.println("get after clear:"  + bb.get());*/

        //limit=position, position=0, mark=-1
        /*bb.flip();
        System.out.println("cap after flip:" + bb.capacity());
        System.out.println("limit after flip:" + bb.limit());
        System.out.println("pos after flip:" + bb.position());
        System.out.println("get after flip:"  + bb.get());*/

        //position=0, mark=-1
        bb.rewind();
        System.out.println("cap after rewind:" + bb.capacity());
        System.out.println("limit after rewind:" + bb.limit());
        System.out.println("pos after rewind:" + bb.position());
        System.out.println("get after rewind:"  + bb.get());

        //System.out.println("getInt after clear:"  + bb.getInt());


        System.out.println("magic:" + 0xCAFEBABE);
    }

    @Test
    public void testSlice(){
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putInt(1);
        bb.putInt(2);
        System.out.println(bb.position());

        ByteBuffer bs = bb.slice();
        /*return new HeapByteBuffer(hb,
                -1,
                0,
                this.remaining(),
                this.remaining(),
                this.position() + offset);*/

        System.out.println(bs.position());
        System.out.println(bs.limit());
    }

    @Test
    public void testCompact(){
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putInt(1);
        bb.putInt(2);
        System.out.println(bb.position());

        ByteBuffer cb = bb.compact();//?
        /*System.arraycopy(hb, ix(position()), hb, ix(0), remaining());
        position(remaining());
        limit(capacity());
        discardMark();
        return this;*/

        System.out.println(cb.position());
        System.out.println(cb.limit());
    }

    @Test
    public void testDuplicate(){
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putInt(1);
        bb.putInt(2);

        ByteBuffer bd = bb.duplicate();
        /*return new HeapByteBuffer(hb,
                this.markValue(),
                this.position(),
                this.limit(),
                this.capacity(),
                offset);*/

        bd.putInt(10);

        System.out.println(bb.getInt());
        System.out.println(bd.getInt());

        System.out.println(bb);
        System.out.println(bd);
    }

    @Test
    public void testAsReadOnlyBuffer(){
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putInt(1);
        bb.putInt(2);

        //same as duplicate except read only HeapByteBufferR
        ByteBuffer br = bb.asReadOnlyBuffer();
        br.putInt(3); //throw exception

    }
}
