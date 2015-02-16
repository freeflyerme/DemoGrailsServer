package demograilsserver

class SysteminfoController {

    def index() {
		
		def directory = params['dir']
		
		def cmd = "ls " + directory
		
		def text = new StringBuffer()
		def err = new StringBuffer()
		
		def proc = cmd.execute()
		proc.consumeProcessOutput(text, err)
		proc.waitForOrKill(1000)
		
		def result = text
		
		println(text)
		
		render(contentType: 'text/json', encoding: "UTF-8") {[
			'result': text
		]}
	}
}
