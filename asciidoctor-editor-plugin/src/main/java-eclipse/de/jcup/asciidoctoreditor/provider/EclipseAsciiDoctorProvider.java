package de.jcup.asciidoctoreditor.provider;

import org.asciidoctor.Asciidoctor;

import de.jcup.asciidoctoreditor.AsciiDoctorOSGIWrapper;
import de.jcup.asciidoctoreditor.InstalledAsciidoctor;

/**
 * An instance providing ogsgi asccidoctor or installed variant
 * @author Albert Tregnaghi
 *
 */
public class EclipseAsciiDoctorProvider implements AsciiDoctorInstanceProvider{
    
    public static final EclipseAsciiDoctorProvider INSTANCE = new EclipseAsciiDoctorProvider();
    
    private static Asciidoctor asciidoctorInstalled;
    private static Asciidoctor asciidoctorEmbedded;
    
    EclipseAsciiDoctorProvider(){
        asciidoctorInstalled = new InstalledAsciidoctor();
        asciidoctorEmbedded = AsciiDoctorOSGIWrapper.INSTANCE.getAsciidoctor();
    }
    
    @Override
    public Asciidoctor getAsciiDoctor(boolean installed){
        if (installed){
            return asciidoctorInstalled;
        }else{
            return asciidoctorEmbedded;
        }
    }
}