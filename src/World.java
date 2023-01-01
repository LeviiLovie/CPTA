public class World {
    public int sizeX;
    public int sizeY;
    public int sizeEX;
    public int sizeEY;
    public int[][] inPutConveyorData;
    public int[][] outPutConveyorData;

    public float[][] world;
    public conveyor[][] conveyors;

    public World(int inPutSizeX, int inPutSizeY) {
        sizeX = inPutSizeX;
        sizeY = inPutSizeY;
        sizeEX = sizeX + 1;
        sizeEY = sizeY + 1;

        inPutConveyorData = new int[][] {
                {1, sizeEY}, {2, 0}, {0, 3}, {sizeEX, 4}
        };
        outPutConveyorData = new int[][] {
                {5, sizeEY}, {6, 0}, {0, 7}, {sizeEX, 8}
        };

//        conveyor = new conveyor[][];

        world = new float[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeY; x++) {
                world[y][x] = 0f;
            }
        }


        world[0][0] = 1.1f;
        world[0][1] = 1.2f;
        world[0][2] = 1.3f;
        world[0][3] = 1.4f;
        world[1][0] = 2.1f;
        world[1][1] = 2.2f;
        world[1][2] = 2.3f;
        world[1][3] = 2.4f;
        world[2][0] = 2.5f;
        world[2][1] = 2.6f;
        world[2][2] = 2.7f;
        world[2][3] = 2.8f;

        world[3][9] = 1.2f;
        world[3][8] = 1.2f;
        world[3][7] = 2.2f;
        world[2][7] = 1.3f;

        world[4][4] = 2.3f;
        world[4][5] = 2.4f;
        world[5][4] = 2.2f;
        world[5][5] = 2.1f;
    }
}

class conveyor {
    public int x;
    public int y;

    public conveyor(int posX, int posY) {
        x = posX;
        y = posY;
    }
}