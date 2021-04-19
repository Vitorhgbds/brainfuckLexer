package interpreter;
import readers.fileModifier;

public class RulesInterpreter {
    private Vm vm;

    public RulesInterpreter(Vm vm){
        this.vm = vm;
    }

    public void commaRule(){
        vm.getMemory()[vm.mp] = vm.getInput().poll();
        vm.pp++;
    }

    public void changeMp(int value){
        vm.mp += value;
        vm.pp++;
    }

    public void setMemoryValue(int value){
        vm.getMemory()[vm.mp] += value;
        vm.pp++;
    }

    public void openBracketRule(String word){
        if(vm.getMemory()[vm.mp] == 0){
            for(; word.charAt(vm.pp) != ']'; vm.pp++);
            vm.pp++;
        }else vm.pp++;
    }

    public void closeBracketRule(String word){
        if(vm.getMemory()[vm.mp] != 0){
            for(; word.charAt(vm.pp) != '['; vm.pp--);
        }else vm.pp++;
    }

    public void dotRule(){
        char c = (char)vm.getMemory()[vm.mp];
        //int asciiCode = vm.getMemory()[vm.mp];
        fileModifier.write("OF.txt", c + "");
        vm.pp++;
    }

    public void dolarRule(){
        StringBuilder msg = new StringBuilder("\n");
        for(int i = 0; i < vm.getMemory().length;i++){
            msg.append("" + vm.getMemory()[i]);
        }
        fileModifier.write("OF.txt",msg.toString());
        vm.pp++;
    }
}
