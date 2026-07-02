    package DocumentEditorGood;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.*;

    interface DocumentElement{
        String render();
    }

    class TextElement implements DocumentElement{
        private final String text;

        TextElement(String text){
            this.text = text;
        }
        @Override
        public String render() {
            return text;
        }
    }

    class ImageElement implements DocumentElement{

        private final String path;

        ImageElement(String path){
            this.path=path;
        }

        @Override
        public String render(){
            StringBuilder sb = new StringBuilder();

            sb.append("Image: [").append(path).append("]");

            return sb.toString();
        }
    }

    interface Persistence{
        void save(String document);
    }

    class FilePersistence implements Persistence{
        @Override
        public void save(String document){
            try {
                FileWriter writer = new FileWriter("document.txt");
                writer.write(document);
                writer.close();
                System.out.println("Document saved to document.txt");
            } catch (IOException e) {
                System.out.println("Error: Unable to open file for writing.");
            }
        }
    }

    class DBPersistence implements Persistence{
        @Override
        public void save(String document){
            System.out.println("Saved to DB");
        }
    }

    class Document{
        private final List<DocumentElement> elements;

        Document(){
            elements = new ArrayList<>();
        }

        public void addElement(DocumentElement element){
            elements.add(element);
        }

        public List<DocumentElement> getElements(){
            return elements;
        }
    }

    class DocumentRenderer{
        private final Document doc;

        DocumentRenderer(Document doc){
            this.doc = doc;
        }

        public String renderDocument(){
            List<DocumentElement> elements = doc.getElements();
            StringBuilder res = new StringBuilder();

            for(DocumentElement el : elements){
                res.append(el.render()).append("\n");
            }

            return res.toString();
        }
    }

    class DocumentEditor{
        private final Document doc;

        DocumentEditor(Document doc){
            this.doc = doc;
        }

        public void addText(String text){
            DocumentElement element = new TextElement(text);
            doc.addElement(element);
        }
        public void addImage(String path){
            DocumentElement element = new ImageElement(path);
            doc.addElement(element);
        }
    }

    class DocumentEditorClient{
        public static void main(String[] args) {
            Document doc = new Document();
            Persistence dbStorage = new DBPersistence();
            DocumentRenderer renderer = new DocumentRenderer(doc);
            DocumentEditor editor = new DocumentEditor(doc);
            editor.addText("My Name is Sumit Kumar");
            editor.addImage("https://sumit.png");
            editor.addText("I live in India");

            System.out.println(renderer.renderDocument());
            dbStorage.save(renderer.renderDocument());

        }
    }