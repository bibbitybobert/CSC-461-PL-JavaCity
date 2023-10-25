package book_robert;

/**
 * Street Tile type derived from the base Tile class
 */
public class Street extends Tile{

    /**
     * Code variable to determine which symbol should represent this street tile.
     * (Used to make output of the city prettier)
     */
    private int adjCode = 0;

    /**
     * Default constructor that sets default symbol and color
     */
    public Street(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '━';
    }

    /**
     * Overriden accept function from Tile class that can accept any Visitor type
     * @param v Visitor of any type to accept
     */
    public void accept(Visitor v){
        v.acceptStreet(this);
    }

    /**
     * @author Dr. Rebenitch
     * \brief Indicate the road tiles adjacent to this one
     *
     * The road time image chosen is dependent on the tiles around
     * it. This is where the adjacency of road tiles is indicated.
     *
     * \param left True if road tile to left
     * \param top True if road tile to top
     * \param bot True if road tile to lower left
     * \param right True if road tile to lower right
     */
    public void setAdjacencies(boolean top, boolean right, boolean bot, boolean left)
    {
        // Create the adjacency code
        int code = (left ? 1 : 0) | (top ? 2 : 0) | (bot ? 4 : 0) | (right ? 8 : 0);
        if (this.adjCode == code)
        {
            // We are already set. Do nothing
            return;
        }

        //unicode starts at 2510
        char[] symbols = {
                '━',      // 0 right
                '━',      // 1 right
                '┃',      // 2 ud
                '┛',      // 3 lu
                '┃',      // 4 ud
                '┓',      // 5 ld
                '┃',      // 6 ud
                '┫',     // 7 lud
                '━',      // 8 right
                '━',      // 9 right
                '┗',      // 10 top
                '┻',     // 11 lur
                '┏',      // 12 dr
                '┳',    // 13 ldr
                '┣',     // 14 udr
                '╋'    // 15 ludr
        };

        // Select the appropriate image
        this.adjCode = code;

        this.symbol = symbols[code];

    }

}
