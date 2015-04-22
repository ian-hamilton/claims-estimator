module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        preserveComments: 'some',
		beautify: false
      },
      core: {
        src: '<%= concat.core.dest %>',
        dest: 'dist/js/<%= pkg.name %>.min.js'
      }
    },
	clean: {
      dist: 'dist'
    },
	concat: {
      options: {
        banner: '<%= banner %>\n<%= jqueryCheck %>\n<%= jqueryVersionCheck %>',
        stripBanners: false
      },
      core: {
        src: [
          'js/claim-maintenance.js'
        ],
        dest: 'dist/js/<%= pkg.name %>.js'
      }
    },
	usebanner: {
      options: {
        position: 'top',
        banner: '<%= banner %>'
      },
      files: {
        src: 'dist/css/*.css'
      }
    },
  });

  // Load the plugin that provides the "uglify" task.
  require('load-grunt-tasks')(grunt, { scope: 'devDependencies' });

  // Full distribution task.
  grunt.registerTask('dist', ['clean:dist', 'dist-js']);
  // JS distribution task.
  grunt.registerTask('dist-js', ['concat', 'uglify:core']);

};