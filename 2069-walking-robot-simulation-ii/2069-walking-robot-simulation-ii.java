class Robot {
    // East - 1,
    // North - 2,
    // West - 3,
    // South - 4

    ArrayList<int[]> pos;
    int idx=0;
    boolean moved = false;
    public Robot(int width, int height) {
        pos = new ArrayList<>();

        //east
        for(int x=0; x<width; x++){         //left->right  =>y=0
            pos.add(new int[]{x, 0, 0});   
        }
        // North
        for(int y=1; y<height; y++){            //bottom->up   =>x=width-1
            pos.add(new int[]{width-1, y, 1});
        }
        //west
        for(int x=width-2; x>=0; x--){         //right->left   =>y=height-1
            pos.add(new int[]{x, height-1, 2});
        }
        //south
        for(int y=height-2; y>0; y--){        //top->bottom    =>x=0
            pos.add(new int[]{0, y, 3});
        }
        
        //edge case when the cycle will complete
        pos.get(0)[2]=3;
    }
    
    public void step(int num) {
        moved=true;
        idx = (idx+num)%pos.size();
    }
    
    public int[] getPos() {
        return new int[]{pos.get(idx)[0], pos.get(idx)[1]};
    }
    
    public String getDir() {
        if(!moved) return "East";
        int dir = pos.get(idx)[2];
        if(dir==0){
            return "East";
        }else if(dir==1){
            return "North";
        }else if(dir==2){
            return "West";
        }
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */