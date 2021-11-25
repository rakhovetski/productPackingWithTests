interface Filter{
    boolean apply(String str);
}

class BeginStringFilter implements Filter{
    private String pattern;
    BeginStringFilter(String pattern){
        this.pattern = pattern;
    }
    public boolean apply(String str){
        if(str.startsWith(pattern)){
            return true;
        }
        else{
            return false;
        }
    }
}

class BeginStringFilter2 implements Filter{
    private String pattern;
    BeginStringFilter2(String pattern){
        this.pattern = pattern;
    }
    public boolean apply(String str){
        if(str.endsWith(pattern)){
            return true;
        }
        else{
            return false;
        }
    }
}

class BeginStringFilter3 implements Filter{
    private String pattern;
    BeginStringFilter3(String pattern){
        this.pattern = pattern;
    }
    public boolean apply(String str){
        if(str.equalsIgnoreCase(pattern)){
            return true;
        }
        else{
            return false;
        }
    }
}

