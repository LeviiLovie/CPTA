public class World {
    public int sizeX;
    public int sizeY;
    public int sizeEX;
    public int sizeEY;
    public int[][] inPutConveyorData;
    public int[][] outPutConveyorData;

    public int[][] world;

    public World(int inPutSizeX, int inPutSizeY) {
        sizeX = inPutSizeX;
        sizeY = inPutSizeY;
        sizeEX = sizeX + 1;
        sizeEY = sizeY + 1;

        inPutConveyorData = new int[][] {
                {2, sizeEY}, {7, 0}, {0, 5}, {sizeEX, 2}
        };
        outPutConveyorData = new int[][] {
                {9, sizeEY}, {4, 0}, {0, 1}, {sizeEX, 7}
        };

        world = new int[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeY; x++) {
                world[y][x] = 0;
            }
        }
    }
}
