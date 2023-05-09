
export class DadosManipulator {

    public static actualData(){
        const today = new Date();
        return today.toISOString().split('T')[0];
    }
}