package alvion.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Alex Burnos
 */
public class JsonObject
{
    private String name;
    @JsonIgnore
    private int value;
    private boolean flag;

    public boolean getFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
